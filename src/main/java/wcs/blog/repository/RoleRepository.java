package wcs.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
