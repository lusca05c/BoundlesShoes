package br.com.primeshoes.api.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "carts")
public class Cart {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
    @JoinColumn(name = "users_id")
	private User user;

	public Cart() {

	}

	public Cart(User user){
		this.user = user;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

}
