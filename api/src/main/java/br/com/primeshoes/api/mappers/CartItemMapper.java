package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.CartItemCreateDTO;
import br.com.primeshoes.api.dtos.CartItemResponseDTO;
import br.com.primeshoes.api.dtos.CartResponseDTO;
import br.com.primeshoes.api.dtos.ProductResponseDTO;
import br.com.primeshoes.api.entites.Cart;
import br.com.primeshoes.api.entites.CartItem;
import br.com.primeshoes.api.entites.Product;

public class CartItemMapper {
    
    public static CartItem toEntity(CartItemCreateDTO cartItemCreateDTO, Cart cart, Product product){

        CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(cartItemCreateDTO.quantity());
            cartItem.setCart(cart);
            
        return cartItem;

    }

    public static CartItemResponseDTO toDTO(CartItem cartItem){

        CartResponseDTO cart = CartMapper.toDTO(cartItem.getCart());
        ProductResponseDTO product = ProductMapper.toDTO(cartItem.getProduct());

        return new CartItemResponseDTO(cartItem.getId(), cart, product, cartItem.getQuantity());
    }

}
