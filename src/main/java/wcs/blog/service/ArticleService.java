package wcs.blog.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import wcs.blog.dto.ArticleCreateRequest;
import wcs.blog.model.Article;
import wcs.blog.model.User;
import wcs.blog.repository.ArticlesRepository;
import wcs.blog.repository.UsersRepository;
import wcs.blog.security.userdetails.UserDetailsImpl;

@Service
public class ArticleService {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	ArticlesRepository articlesRepository;
	
	public void create(ArticleCreateRequest articleCreateRequest) {
		
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl)authentication.getPrincipal();
		
		User user = usersRepository.getById(userDetailsImpl.getId());
		
		Article article = new Article();
		article.setTitle(articleCreateRequest.getTitle());
		article.setContent(articleCreateRequest.getContent());
		article.setCreatedOn(LocalDateTime.now());
		article.setUser(user);
		articlesRepository.save(article);
	}

	public Optional<Article> read(Long id) {
		
		return articlesRepository.findById(id);
		
	}

}
