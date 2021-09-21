package wcs.blog.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import wcs.blog.dto.LoginRequest;
import wcs.blog.dto.RegisterRequest;
import wcs.blog.model.User;
import wcs.blog.model.ERole;
import wcs.blog.model.Role;
import wcs.blog.repository.RoleRepository;
import wcs.blog.repository.UsersRepository;
import wcs.blog.security.jwt.JwtUtils;

@Service
public class AuthService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	public void register(RegisterRequest registerRequest) throws Exception {
		
		// on verifie si le mail existe déjà
		if(usersRepository.existsByEmail(registerRequest.getEmail())) {
			throw new Exception("User with this email already exist !");
		}
		// on verifie si le username existe déjà
		if(usersRepository.existsByUsername(registerRequest.getUsername())) {
			throw new Exception("User with this username already exist !");
		}
		
		
		
		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		
		usersRepository.save(user);
	}
	
	public String login(LoginRequest loginRequest) {
		
		Authentication authentication =  authenticationManager.authenticate( 
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return jwtUtils.generateJwtToken(authentication);
		
	}
}
