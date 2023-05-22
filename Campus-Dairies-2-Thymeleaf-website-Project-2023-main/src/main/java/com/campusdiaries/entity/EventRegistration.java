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

@Entity
@Table(name = "event_registration")
public class EventRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
	private Event event;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	@Basic
	@Column(name = "payment_type", nullable = false, length = 20)
	private String paymentType;

	@Basic
	@Column(name = "payment_detail", nullable = false, length = 255)
	private String paymentDetail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		EventRegistration other = (EventRegistration) obj;
		return Objects.equals(id, other.id) && Objects.equals(paymentType, other.paymentType)
				&& Objects.equals(paymentDetail, other.paymentDetail);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, paymentType, paymentDetail);
	}

	public EventRegistration() {
		super();
	}

	public EventRegistration(String paymentType, String paymentDetail) {
		super();
		this.paymentType = paymentType;
		this.paymentDetail = paymentDetail;
	}

	@Override
	public String toString() {
		return "EventRegistration [id=" + id + ", paymentType=" + paymentType + ", paymentDetail=" + paymentDetail
				+ "]";
	}
}
