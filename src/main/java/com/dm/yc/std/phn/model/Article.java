/**
 * 
 */
package com.dm.yc.std.phn.model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Administrator
 */
@Table(name="tb_article")
@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tb_articleId", nullable = false, length = 40)
	private Integer ArticleId;
	
	@Column(name = "tb_title", nullable = false, length = 32)
	private String Title;
	
	@Column(name = "tb_content", nullable = false, length = 128)
	private String Content;
	
	@Column(name = "tb_anthor", nullable = false, length = 15)
	private String Author;
	
	@Column(name = "tb_type", nullable = false, length = 15)
	private String Type;
	
	@Column(name = "tb_readCount", nullable = false, length = 15)
	private Integer ReadCount;
	
	@Column(name = "tb_imageUrl", nullable = false, length = 32)
	private String ImageUrl;
	
	@Column(name = "tb_publishDate", nullable = false, length = 20)
	private Calendar PublishDate;
	
	/*@OneToMany(mappedBy="tb_article")
	private Set<Comment> sets;
	
	public Set<Comment> getSets() {
		return sets;
	}
	public void setSets(Set<Comment> sets) {
		this.sets = sets;
	}*/
	public Integer getArticleId() {
		return ArticleId;
	}
	public void setArticleId(Integer articleId) {
		ArticleId = articleId;
	}
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Integer getReadCount() {
		return ReadCount;
	}
	public void setReadCount(Integer readCount) {
		ReadCount = readCount;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	
	public Calendar getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(Calendar publishDate) {
		PublishDate = publishDate;
	}
}
