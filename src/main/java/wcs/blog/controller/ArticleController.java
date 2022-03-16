package wcs.blog.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcs.blog.dto.ArticleCreateRequest;
import wcs.blog.model.Article;
import wcs.blog.repository.ArticlesRepository;
import wcs.blog.service.ArticleService;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	ArticlesRepository articlesRepository;
	
	@GetMapping
	public List<Article> getAll(){
		return articlesRepository.findAll();
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest){		
		articleService.create(articleCreateRequest);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<Article> read(@PathVariable(required = true) Long id){
		
		Optional<Article> optArticle = articleService.read(id);
		
		if(optArticle.isEmpty()) {
			return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Article>(optArticle.get(), HttpStatus.OK);
	}
}
