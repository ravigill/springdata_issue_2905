package nl.reproduction.issue2095.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
// The unique constraint does not work yet, it throws an exception about not able to find column role. Very strange
@Table(name="USER_ROLES", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "role"}))
public class UserRole {
	@Transient
	public static final String ROLE_ADMIN = "ADMIN";
	@Transient
	public static final String ROLE_MODERATOR = "MOD";
	@Transient
	public static final String ROLE_USER = "USER";
	@Transient
	public static final String ROLE_PASSENGER = "PASSENGER";
	@Transient
	public static final String ROLE_DISCOUNTHOLDER = "DISCOUNTHOLDER";
	@Transient
	public static final String ROLE_ANONYMOUS = "ANON";
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer id;
	
	@Column(name = "role", nullable = false, length = 45)
	private String role;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name = "username", nullable = false)
	private User user;

	public UserRole(){
		super();
	}
	
	public UserRole(User user, String role){
		this.user = user;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
}
