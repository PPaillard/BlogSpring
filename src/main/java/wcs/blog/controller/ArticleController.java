package wcs.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcs.blog.dto.ArticleCreateRequest;
import wcs.blog.service.ArticleService;

@RestController
@RequestMapping("/api/article")
@CrossOrigin
public class ArticleController {
	
	@Autowired
	ArticleService articleService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest){
		
		articleService.create(articleCreateRequest);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
