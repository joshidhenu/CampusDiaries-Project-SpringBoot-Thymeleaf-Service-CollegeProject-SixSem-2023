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
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@Basic
	@Column(name = "title", nullable = false, length = 255)
	private String title;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "last_date", nullable = false)
	private Date lastDate;

	@Basic
	@Column(name = "banner", nullable = false, length = 255)
	private String banner;

	@Basic
	@Column(name = "detail", nullable = false, length = 255)
	private String detail;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "entry_date", nullable = false)
	private Date entryDate;

	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	private Set<EventRegistration> eventRegistration = new HashSet<>();

	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	private Set<PhotosGallery> photosGallery = new HashSet<>();

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<EventRegistration> getEventRegistrations() {
		return eventRegistration;
	}

	public void setEventRegistrations(Set<EventRegistration> eventRegistration) {
		this.eventRegistration = eventRegistration;
	}

	public Set<PhotosGallery> getPhotosGalleries() {
		return photosGallery;
	}

	public void setPhotosGalleries(Set<PhotosGallery> photosGallery) {
		this.photosGallery = photosGallery;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(lastDate, other.lastDate)
				&& Objects.equals(banner, other.banner) && Objects.equals(detail, other.detail)
				&& Objects.equals(status, other.status) && Objects.equals(entryDate, other.entryDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, startDate, lastDate, banner, detail, status, entryDate);
	}

	public Event() {
		super();
	}

	public Event(String title, Date startDate, Date lastDate, String banner, String detail, Integer status,
			Date entryDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.lastDate = lastDate;
		this.banner = banner;
		this.detail = detail;
		this.status = status;
		this.entryDate = entryDate;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", startDate=" + startDate + ", lastDate=" + lastDate
				+ ", banner=" + banner + ", detail=" + detail + ", status=" + status + ", entryDate=" + entryDate + "]";
	}
	
	@Transient
	public String getImagePath() {
	    if(banner == null)
	    return null;
	return "/assets1/images/event/" +banner;
	    
	}
}
