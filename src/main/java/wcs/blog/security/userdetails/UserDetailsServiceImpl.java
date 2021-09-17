package wcs.blog.security.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import wcs.blog.model.User;
import wcs.blog.repository.UsersRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = usersRepository.findByName(username).orElseThrow(
				() ->  new UsernameNotFoundException("L'utilisateur n'existe pas en BDD"));
		
		return UserDetailsImpl.build(user);
	}

}
