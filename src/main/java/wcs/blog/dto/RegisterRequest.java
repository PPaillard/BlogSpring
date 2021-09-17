package wcs.blog.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterRequest {

	@NotBlank
	@NotNull
	@Size(max = 50)
	private String username;
	
	@NotBlank
	@NotNull
	@Size(max = 100)
	@Email
	private  String email;
	
	@NotBlank
	@NotNull
	@Size(max = 20)
	private  String password;
	
	@Size(max = 50)
	private String city;

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
}
