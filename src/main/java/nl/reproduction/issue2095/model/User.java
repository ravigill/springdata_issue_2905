package nl.reproduction.issue2095.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
@Table(name="USERS")
public class User{
	
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean enabled = false;
	private Date dateCreated;
	private Date dateModified;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = UserRole.class)
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public DateTime getDateCreated() {
		return new DateTime(dateCreated);
	}
	public void setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated.toDate();
	}
	public DateTime getDateModified() {
		return new DateTime(dateModified);
	}
	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified.toDate();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRole) {
		this.userRoles = userRole;
	}
	
	public void addUserRole(UserRole role){
		role.setUser(this);
		this.userRoles.add(role);
	}
}
