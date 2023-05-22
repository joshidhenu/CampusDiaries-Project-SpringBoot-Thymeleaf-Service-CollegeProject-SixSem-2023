package com.campusdiaries.entity;

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
import javax.persistence.Transient;

@Entity
@Table(name = "photos_gallery")
public class PhotosGallery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
	private Event event;

	@Basic
	@Column(name = "photo", nullable = false, length = 50)
	private String photo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		PhotosGallery other = (PhotosGallery) obj;
		return Objects.equals(id, other.id) && Objects.equals(photo, other.photo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, photo);
	}

	public PhotosGallery() {
		super();
	}

	public PhotosGallery(String photo) {
		super();
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "PhotosGallery [id=" + id + ", photo=" + photo + "]";
	}
	@Transient
	public String getImagePath() {
	    if(photo == null)
	    return null;
	return "/assets1/images/photos/"+photo;
	    
	}
}
