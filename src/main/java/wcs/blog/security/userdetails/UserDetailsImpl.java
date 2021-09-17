package wcs.blog.security.userdetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import wcs.blog.model.Role;
import wcs.blog.model.User;

public class UserDetailsImpl implements UserDetails {
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private Set<? extends GrantedAuthority> grantedAuthority;
	
	
	public static UserDetailsImpl build(User user) {
		
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		userDetailsImpl.setId(user.getId());
		userDetailsImpl.setUsername(user.getUsername());
		userDetailsImpl.setPassword(user.getPassword());
		
		Set<SimpleGrantedAuthority> authoritys = new HashSet<SimpleGrantedAuthority>();
		
		for (Role role : user.getRoles()) {
			authoritys.add( new SimpleGrantedAuthority(role.getName().name()));
		}
		
		userDetailsImpl.setGrantedAuthority(authoritys);
		return userDetailsImpl;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.grantedAuthority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<? extends GrantedAuthority> getGrantedAuthority() {
		return grantedAuthority;
	}


	public void setGrantedAuthority(Set<? extends GrantedAuthority> grantedAuthority) {
		this.grantedAuthority = grantedAuthority;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
