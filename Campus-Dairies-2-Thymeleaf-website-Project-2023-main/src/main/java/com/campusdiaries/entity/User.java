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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Basic
	@Column(name = "phone", nullable = false, length = 50)
	private String phone;

	@Basic
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Basic
	@Column(name = "password", nullable = false, length = 20)
	private String password;

	@Basic
	@Column(name = "role", nullable = false, length = 20)
	private String role;

	@Basic
	@Column(name = "status", nullable = false, length = 10)
	private String status;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "entry_date", nullable = false)
	private Date entryDate;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "logout_date", nullable = false)
	private Date logoutDate;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<CommentPost> commentPost = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Event> event = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<EventRegistration> eventRegistration = new HashSet<>();

//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//	private Set<Notification> rnotification = new HashSet<>();
//
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//	private Set<Notification> snotification = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Post> post = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<ReplyComment> replyComment = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<StaffMaster> staffMaster = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<StudentMaster> studentMaster = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Suggestion> suggestion = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<TempUser> tempUser = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public Set<CommentPost> getCommentPosts() {
		return commentPost;
	}

	public void setCommentPosts(Set<CommentPost> commentPost) {
		this.commentPost = commentPost;
	}

	public Set<Event> getEvents() {
		return event;
	}

	public void setEvents(Set<Event> event) {
		this.event = event;
	}

	public Set<EventRegistration> getEventRegistrations() {
		return eventRegistration;
	}

	public void setEventRegistrations(Set<EventRegistration> eventRegistration) {
		this.eventRegistration = eventRegistration;
	}

	

	public Set<Post> getPosts() {
		return post;
	}

	public void setPosts(Set<Post> post) {
		this.post = post;
	}

	public Set<ReplyComment> getReplyComments() {
		return replyComment;
	}

	public void setReplyComments(Set<ReplyComment> replyComment) {
		this.replyComment = replyComment;
	}

	public Set<StaffMaster> getStaffMasters() {
		return staffMaster;
	}

	public void setStaffMasters(Set<StaffMaster> staffMaster) {
		this.staffMaster = staffMaster;
	}

	public Set<StudentMaster> getStudentMasters() {
		return studentMaster;
	}

	public void setStudentMasters(Set<StudentMaster> studentMaster) {
		this.studentMaster = studentMaster;
	}

	public Set<Suggestion> getSuggestions() {
		return suggestion;
	}

	public void setSuggestions(Set<Suggestion> suggestion) {
		this.suggestion = suggestion;
	}

	public Set<TempUser> getTempUsers() {
		return tempUser;
	}

	public void setTempUsers(Set<TempUser> tempUser) {
		this.tempUser = tempUser;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(status, other.status)
				&& Objects.equals(entryDate, other.entryDate) && Objects.equals(logoutDate, other.logoutDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, phone, email, password, role, status, entryDate, logoutDate);
	}

	public User() {
		super();
	}

	public User(String name, String phone, String email, String password, String role, String status, Date entryDate,
			Date logoutDate) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
		this.entryDate = entryDate;
		this.logoutDate = logoutDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", status=" + status + ", entryDate=" + entryDate + ", logoutDate=" + logoutDate
				+ "]";
	}
}
