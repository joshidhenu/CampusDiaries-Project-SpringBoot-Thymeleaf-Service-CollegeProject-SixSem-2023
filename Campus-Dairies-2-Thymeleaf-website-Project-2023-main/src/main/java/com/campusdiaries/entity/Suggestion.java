package com.campusdiaries.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "suggestion")
public class Suggestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@Basic
	@Column(name = "message", nullable = false, length = 255)
	private String message;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "entry_date", nullable = false)
	private Date entryDate;

	@Basic
	@Column(name = "like_count", nullable = false)
	private Integer likeCount;

	@Basic
	@Column(name = "dislike_count", nullable = false)
	private Integer dislikeCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Suggestion other = (Suggestion) obj;
		return Objects.equals(id, other.id) && Objects.equals(message, other.message)
				&& Objects.equals(entryDate, other.entryDate) && Objects.equals(likeCount, other.likeCount)
				&& Objects.equals(dislikeCount, other.dislikeCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message, entryDate, likeCount, dislikeCount);
	}

	public Suggestion() {
		super();
	}

	public Suggestion(String message, Date entryDate, Integer likeCount, Integer dislikeCount) {
		super();
		this.message = message;
		this.entryDate = entryDate;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
	}

	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", message=" + message + ", entryDate=" + entryDate + ", likeCount=" + likeCount
				+ ", dislikeCount=" + dislikeCount + "]";
	}
}
