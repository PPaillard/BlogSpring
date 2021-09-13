package wcs.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.models.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
