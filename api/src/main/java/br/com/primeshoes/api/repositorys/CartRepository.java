package br.com.primeshoes.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeshoes.api.entites.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
    
}
