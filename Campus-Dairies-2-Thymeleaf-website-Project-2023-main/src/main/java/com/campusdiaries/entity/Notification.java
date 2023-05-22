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
@Table(name = "notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver_user_id", referencedColumnName = "id", nullable = false)
	private User ruser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_user_id", referencedColumnName = "id", nullable = false)
	private User suser;

	@Basic
	@Column(name = "title", nullable = false, length = 50)
	private String title;

	@Basic
	@Column(name = "is_read", nullable = false, length = 1)
	private String isRead;

	@Basic
	@Column(name = "message", nullable = false, length = 255)
	private String message;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "entry_date", nullable = false)
	private Date entryDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
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

	public User getReceiverUser() {
		return ruser;
	}

	public void setReceiverUser(User receiverUser) {
		this.ruser = receiverUser;
	}

	public User getSenderUser() {
		return suser;
	}

	public void setSenderUser(User senderUser) {
		this.suser = senderUser;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title)
				&& Objects.equals(isRead, other.isRead) && Objects.equals(message, other.message)
				&& Objects.equals(entryDate, other.entryDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, isRead, message, entryDate);
	}

	public Notification() {
		super();
	}

	public Notification(String title, String isRead, String message, Date entryDate) {
		super();
		this.title = title;
		this.isRead = isRead;
		this.message = message;
		this.entryDate = entryDate;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", title=" + title + ", isRead=" + isRead + ", message=" + message
				+ ", entryDate=" + entryDate + "]";
	}
}
