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
@Table(name = "student_master")
public class StudentMaster {

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

	@Basic
	@Column(name = "course", nullable = false, length = 50)
	private String course;

	@Basic
	@Column(name = "semester", nullable = false, length = 10)
	private String semester;

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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
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
		StudentMaster other = (StudentMaster) obj;
		return Objects.equals(id, other.id) && Objects.equals(gender, other.gender)
				&& Objects.equals(phone, other.phone) && Objects.equals(photo, other.photo)
				&& Objects.equals(city, other.city) && Objects.equals(department, other.department)
				&& Objects.equals(course, other.course) && Objects.equals(semester, other.semester);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, gender, phone, photo, city, department, course, semester);
	}

	public StudentMaster() {
		super();
	}

	public StudentMaster(String gender, String phone, String photo, String city, String department, String course,
			String semester) {
		super();
		this.gender = gender;
		this.phone = phone;
		this.photo = photo;
		this.city = city;
		this.department = department;
		this.course = course;
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "StudentMaster [id=" + id + ", gender=" + gender + ", phone=" + phone + ", photo=" + photo + ", city="
				+ city + ", department=" + department + ", course=" + course + ", semester=" + semester + "]";
	}
	@Transient
	public String getImagePath() {
	    if(photo == null)
	    return null;
	return "/assets1/images/students/" +photo;
	    
	}
}
