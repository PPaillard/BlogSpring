package wcs.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import wcs.blog.dto.LoginRequest;
import wcs.blog.dto.RegisterRequest;
import wcs.blog.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/register")
	public void register(@Valid @RequestBody RegisterRequest registerRequest){
		
		// TODO enregistrer l'utilisateur
		try {
			authService.register(registerRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		
	}
	
	@PostMapping("/login")
	public String login(@Valid @RequestBody LoginRequest loginRequest){
		return authService.login(loginRequest);
	}
}
