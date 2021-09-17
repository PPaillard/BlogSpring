package wcs.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {

	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
	Optional<User> findByName(String username);
}
