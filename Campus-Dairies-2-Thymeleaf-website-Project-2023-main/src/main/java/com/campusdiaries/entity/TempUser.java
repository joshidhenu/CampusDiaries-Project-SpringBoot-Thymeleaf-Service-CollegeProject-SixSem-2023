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
@Table(name = "temp_user")
public class TempUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@Basic
	@Column(name = "college_name", nullable = false, length = 100)
	private String collegeName;
	
	@Basic
	@Column(name = "photo", nullable = false, length = 100)
	private String photo;
	
	

	@Basic
	@Column(name = "college_id_photo", nullable = false, length = 255)
	private String collegeIdPhoto;

	

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

	public String getCollegeName() {
	    return collegeName;
	}

	public void setCollegeName(String collegeName) {
	    this.collegeName = collegeName;
	}

	public String getPhoto() {
	    return photo;
	}

	public void setPhoto(String photo) {
	    this.photo = photo;
	}

	public String getCollegeIdPhoto() {
	    return collegeIdPhoto;
	}

	public void setCollegeIdPhoto(String collegeIdPhoto) {
	    this.collegeIdPhoto = collegeIdPhoto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		TempUser other = (TempUser) obj;
		return Objects.equals(id, other.id) && Objects.equals(collegeName, other.collegeName)
				&& Objects.equals(collegeIdPhoto, other.collegeIdPhoto)
				 && Objects.equals(photo,  other.photo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, collegeName, collegeIdPhoto, photo);
	}

	public TempUser() {
		super();
	}

	public TempUser(String collegeName, String collegeIdPhoto, String photo) {
		super();
		this.collegeName = collegeName;
		this.collegeIdPhoto = collegeIdPhoto;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "TempUser [id=" + id + ", collegeName=" + collegeName + ", collegeIdPhoto=" + collegeIdPhoto + ", photo = " + photo+"]";
	}
	@Transient
	public String getImagePath() {
	    if(collegeIdPhoto == null)
	    return null;
	return "/assets1/images/temps/"+collegeIdPhoto;
	    
	}
	
	@Transient
	public String getPhotoPath() {
	    if(photo == null)
	    return null;
	return "/assets1/images/temps/"+photo;
	    
	}
}
