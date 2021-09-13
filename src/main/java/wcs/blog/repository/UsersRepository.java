package wcs.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
