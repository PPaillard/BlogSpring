package wcs.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.model.ERole;
import wcs.blog.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERole roleUser);

}
