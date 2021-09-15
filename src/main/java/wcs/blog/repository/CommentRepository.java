package wcs.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
