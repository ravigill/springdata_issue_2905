package nl.reproduction.issue2095.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import nl.reproduction.issue2095.model.UserRole;
import nl.reproduction.issue2095.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService{

		@Autowired
		private UserRepository userRepository;
		
		@Transactional
		@Override
		public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
			if(username == null){
				throw new RuntimeException("Username must not be null");
			}
			nl.reproduction.issue2095.model.User user = userRepository.findByUsername(username);
			if(user == null || user.getUsername().isEmpty()){
				throw new RuntimeException("User: \""+username+"\" does not exist.");
			}
			List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());
			return buildUserForAuthentication(user, authorities);
		}

		private User buildUserForAuthentication(nl.reproduction.issue2095.model.User user, 
				List<GrantedAuthority> authorities) {
				return new User(
						user.getUsername(), 
						user.getPassword(),
						user.isEnabled(), 
						true, 
						true, 
						true, 
						authorities
						);
			}
	 
		private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
			Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
			// Build user's authorities
			for (UserRole userRole : userRoles) {
				setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
			}
			List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
			return Result;
		}

}
