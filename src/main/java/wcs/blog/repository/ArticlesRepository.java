package wcs.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wcs.blog.model.Article;

public interface ArticlesRepository extends JpaRepository<Article, Long> {

}
