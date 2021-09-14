package wcs.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {

}
