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
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String description;
	private float price;
	private float raitingA;
	
	@ManyToOne
    @JoinColumn(name = "users_id")
	private User user;
	
	
	@CreationTimestamp
	private Instant created_at;
	@UpdateTimestamp
	private Instant updated_at;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
    @JoinColumn(name = "brands_id")
	private Brand brand;
	
	public Product () { }
	
	public Product(long id, String name, String description, float price, User user, Instant created_at, Instant updated_at, float raitingA, Category category, Brand brand) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.user = user;
		this.raitingA = raitingA;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.category = category;
		this.brand = brand;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	public long getId() {
		return id;
	}

	public float getraitingA() {
		return raitingA;
	}

	public void setraitingA(float raitingA) {
		this.raitingA = raitingA;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
