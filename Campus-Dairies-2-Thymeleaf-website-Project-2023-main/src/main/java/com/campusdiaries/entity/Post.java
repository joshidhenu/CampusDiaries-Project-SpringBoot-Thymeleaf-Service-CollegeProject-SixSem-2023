package com.campusdiaries.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@Basic
	@Column(name = "photo", nullable = false, length = 50)
	private String photo;
	
	@Basic
	@Column(name = "message", nullable = false, length = 255)
	private String message;

	@Basic
	@Column(name = "like_count", nullable = false)
	private Integer likeCount;

	@Basic
	@Column(name = "dislike_count", nullable = false)
	private Integer dislikeCount;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "entry_date", nullable = false)
	private Date entryDate;

	@Basic
	@Column(name = "status", nullable = false, length = 10)
	private String status;

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private Set<CommentPost> commentPost = new HashSet<>();


	public Integer getId() {
	    return id;
	}


	public void setId(Integer id) {
	    this.id = id;
	}


	public User getUser() {
	    return user;
	}


	public void setUser(User user) {
	    this.user = user;
	}


	public String getPhoto() {
	    return photo;
	}


	public void setPhoto(String photo) {
	    this.photo = photo;
	}


	public String getMessage() {
	    return message;
	}


	public void setMessage(String message) {
	    this.message = message;
	}


	public Integer getLikeCount() {
	    return likeCount;
	}


	public void setLikeCount(Integer likeCount) {
	    this.likeCount = likeCount;
	}


	public Integer getDislikeCount() {
	    return dislikeCount;
	}


	public void setDislikeCount(Integer dislikeCount) {
	    this.dislikeCount = dislikeCount;
	}


	public Date getEntryDate() {
	    return entryDate;
	}


	public void setEntryDate(Date entryDate) {
	    this.entryDate = entryDate;
	}


	public String getStatus() {
	    return status;
	}


	public void setStatus(String status) {
	    this.status = status;
	}


	public Set<CommentPost> getCommentPost() {
	    return commentPost;
	}


	public void setCommentPost(Set<CommentPost> commentPost) {
	    this.commentPost = commentPost;
	}


	public Post() {
	    super();
	}


	public Post(String photo, String message, Integer likeCount, Integer dislikeCount, Date entryDate,
		String status) {
	    super();
	    this.photo = photo;
	    this.message = message;
	    this.likeCount = likeCount;
	    this.dislikeCount = dislikeCount;
	    this.entryDate = entryDate;
	    this.status = status;
	}


	@Override
	public int hashCode() {
	    return Objects.hash(commentPost, dislikeCount, entryDate, id, likeCount, message, photo, status, user);
	}


	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Post other = (Post) obj;
	    return Objects.equals(commentPost, other.commentPost) && Objects.equals(dislikeCount, other.dislikeCount)
		    && Objects.equals(entryDate, other.entryDate) && Objects.equals(id, other.id)
		    && Objects.equals(likeCount, other.likeCount) && Objects.equals(message, other.message)
		    && Objects.equals(photo, other.photo) && Objects.equals(status, other.status)
		    && Objects.equals(user, other.user);
	}


	@Transient
	public String getImagePath() {
	    if(photo == null)
	    return null;
	return "/assets1/images/posts/"+photo;
	    
	}
}
