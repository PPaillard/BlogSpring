package wcs.blog.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wcs.blog.dto.ArticleCreateRequest;
import wcs.blog.model.Article;
import wcs.blog.model.User;
import wcs.blog.repository.ArticlesRepository;
import wcs.blog.repository.UsersRepository;

@Service
public class ArticleService {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	ArticlesRepository articlesRepository;
	
	public void create(ArticleCreateRequest articleCreateRequest) {
		
		User user = usersRepository.findById(articleCreateRequest.getIdUser())
				.orElseThrow(() -> new RuntimeException("L'utilisateur n'a pas été trouvé."));
		
		System.out.println(user.toString());
		
		Article article = new Article();
		article.setTitle(articleCreateRequest.getTitle());
		article.setContent(articleCreateRequest.getContent());
		article.setCreatedOn(new Date());
		article.setUser(user);
		articlesRepository.save(article);
	}

}
