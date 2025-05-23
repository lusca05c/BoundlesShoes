package br.com.primeshoes.api.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_variations")
public class ProductVariation {

	public ProductVariation(long id, String color, String size, long stock, Product product) {
		super();
		this.id = id;
		this.color = color;
		this.size = size;
		this.stock = stock;
		this.product = product;
	}
	
	public ProductVariation() { }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String color;
	private String size;
	private long stock;
	
	@ManyToOne
    @JoinColumn(name = "products_id")
	private Product product;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}
	
}
