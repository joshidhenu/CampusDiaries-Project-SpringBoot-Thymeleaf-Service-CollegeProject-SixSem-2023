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
@Table(name = "staff_master")
public class StaffMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@Basic
	@Column(name = "gender", nullable = false, length = 10)
	private String gender;

	@Basic
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Basic
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;

	@Basic
	@Column(name = "photo", nullable = false, length = 50)
	private String photo;

	@Basic
	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@Basic
	@Column(name = "department", nullable = false, length = 50)
	private String department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
		StaffMaster other = (StaffMaster) obj;
		return Objects.equals(id, other.id) && Objects.equals(gender, other.gender)
				&& Objects.equals(email, other.email) && Objects.equals(phone, other.phone)
				&& Objects.equals(photo, other.photo) && Objects.equals(city, other.city)
				&& Objects.equals(department, other.department);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, gender, email, phone, photo, city, department);
	}

	public StaffMaster() {
		super();
	}

	public StaffMaster(String gender, String email, String phone, String photo, String city, String department) {
		super();
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
		this.city = city;
		this.department = department;
	}

	@Override
	public String toString() {
		return "StaffMaster [id=" + id + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", photo="
				+ photo + ", city=" + city + ", department=" + department + "]";
	}
	@Transient
	public String getImagePath() {
	    if(photo == null)
	    return null;
	return "/assets1/images/staffs/" +photo;
	    
	}
}
