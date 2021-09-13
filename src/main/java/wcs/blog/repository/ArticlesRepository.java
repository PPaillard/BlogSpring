package wcs.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.models.Articles;

public interface ArticlesRepository extends JpaRepository<Articles, Long> {

}
