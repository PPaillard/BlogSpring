package wcs.blog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArticleCreateRequest {
	
	@NotBlank
	@NotNull
	@Size(max = 100)
	private String title;
	
	@NotBlank
	@NotNull
	private String content;
	
	@NotNull
	private Long idUser;
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "ArticleCreateRequest [title=" + title + ", content=" + content + ", idUser=" + idUser + "]";
	}

}
