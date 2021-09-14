package wcs.blog.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Le nom d'utilisateur est obligatoire")
	@Size(max = 50)
	@NotNull
	private String username;

	@NotBlank(message = "Le mail est obligatoire")
	@Size(max = 100)
	@Email
	@NotNull
	private String email;

	@NotBlank(message = "Le mot de passe est obligatoire")
	@Size(max = 120)
	@NotNull
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roleUser",
	joinColumns = @JoinColumn(name="idUser"),
	inverseJoinColumns = @JoinColumn(name="idRole"))
	@NotNull
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "user")
	private List<Article> articles = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Comment> comments = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
