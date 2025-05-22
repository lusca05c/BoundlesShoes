package br.com.primeshoes.api.entites;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

	public Address(long id, String street, String city, String state, String zipCode, String number, Instant created_at,
			Instant updated_at, User user) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.number = number;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user = user;
	}
	
	public Address(){ }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String number;
	
	@CreationTimestamp
	private Instant created_at;
	@UpdateTimestamp
	private Instant updated_at;
	
	@ManyToOne
    @JoinColumn(name = "users_id")
	private User user;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Instant getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Instant created_at) {
		this.created_at = created_at;
	}

	public Instant getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Instant updated_at) {
		this.updated_at = updated_at;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}
	
	
}
