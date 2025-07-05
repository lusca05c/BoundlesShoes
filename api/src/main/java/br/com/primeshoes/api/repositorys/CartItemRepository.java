package br.com.primeshoes.api.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeshoes.api.entites.Cart;
import br.com.primeshoes.api.entites.CartItem;
import br.com.primeshoes.api.entites.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
    List<CartItem> findAllByCart(Cart cart);

    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);

}
