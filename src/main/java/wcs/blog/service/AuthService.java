package wcs.blog.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import wcs.blog.dto.RegisterRequest;
import wcs.blog.model.User;
import wcs.blog.model.ERole;
import wcs.blog.model.Role;
import wcs.blog.repository.RoleRepository;
import wcs.blog.repository.UsersRepository;

@Service
public class AuthService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public void register(RegisterRequest registerRequest) {
		
		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());
		
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		
		usersRepository.save(user);
	}
}
