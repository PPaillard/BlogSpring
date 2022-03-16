package wcs.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcs.blog.model.User;
import wcs.blog.repository.UsersRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping
	public List<User> getAll(){
		return usersRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(required = true) Long id) {
		if (usersRepository.findById(id).isEmpty())
			return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);

		usersRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
