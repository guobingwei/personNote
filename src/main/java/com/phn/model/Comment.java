/**
 * 
 */
package com.phn.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Administrator
 */
@Table(name="tb_comment")
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tb_commentId", nullable=false, length=40) 
	private Integer CommentId;
	
	@ManyToOne(cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="ArticleId")
	private Article ArticleId;
	
	public Article getArticleId() {
		return ArticleId;
	}
	public void setArticleId(Article articleId) {
		ArticleId = articleId;
	}
	@Column(name = "tb_commentBy", nullable=false, length=32) 
	private String CommentBy;
	
	@Column(name = "tb_commentDetails", nullable=false, length=32) 
	private String CommentDetails;
	
	@Column(name = "tb_commentDate", nullable=false, length=32) 
	private Calendar CommentDate;
	
	public Integer getCommentId() {
		return CommentId;
	}
	public void setCommentId(Integer commentId) {
		CommentId = commentId;
	}
	
	public String getCommentBy() {
		return CommentBy;
	}
	public void setCommentBy(String commentBy) {
		CommentBy = commentBy;
	}
	public String getCommentDetails() {
		return CommentDetails;
	}
	public void setCommentDetails(String commentDetails) {
		CommentDetails = commentDetails;
	}
	public Calendar getCommentDate() {
		return CommentDate;
	}
	public void setCommentDate(Calendar commentDate) {
		CommentDate = commentDate;
	}
}
