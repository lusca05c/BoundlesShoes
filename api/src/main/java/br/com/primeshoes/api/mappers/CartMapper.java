package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.CartCreateDTO;
import br.com.primeshoes.api.dtos.CartResponseDTO;
import br.com.primeshoes.api.dtos.UserResponseDTO;
import br.com.primeshoes.api.entites.Cart;
import br.com.primeshoes.api.entites.User;

public class CartMapper {
    
    public static Cart toEntity(CartCreateDTO cartCreateDTO, User user){
        
        Cart cart = new Cart();
            cart.setUser(user);

        return cart;
    }

    public static CartResponseDTO toDTO(Cart cart){
        UserResponseDTO user =  UserMapper.toDTO(cart.getUser());
        return new CartResponseDTO(cart.getId(), user);
    }

}
