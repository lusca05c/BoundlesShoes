package br.com.primeshoes.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.CartCreateDTO;
import br.com.primeshoes.api.dtos.CartItemCreateDTO;
import br.com.primeshoes.api.dtos.CartItemResponseDTO;
import br.com.primeshoes.api.dtos.CartItemUpdateDTO;
import br.com.primeshoes.api.entites.Cart;
import br.com.primeshoes.api.entites.CartItem;
import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.entites.User;
import br.com.primeshoes.api.mappers.CartItemMapper;
import br.com.primeshoes.api.repositorys.CartItemRepository;
import br.com.primeshoes.api.repositorys.CartRepository;
import br.com.primeshoes.api.repositorys.ProductRepository;
import br.com.primeshoes.api.repositorys.UserRepository;

@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    private ProductRepository productRepository;
    private UserRepository userRepository;

    public CartService (ProductRepository productRepository, UserRepository userRepository){
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public CartCreateDTO createCart(long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
        
        return new CartCreateDTO(user.getId());
    }

    // Quanto ao que diz respeito dos itens do carrinho

    public void store(CartItemCreateDTO dto, long cartId) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        Product product = productRepository.findById(dto.product_id())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        Optional<CartItem> existingItem = cartItemRepository.findByCartAndProduct(cart, product);

        if(existingItem.isPresent()){
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + dto.quantity());
            cartItemRepository.save(item);
        }else{
            cartItemRepository.save(CartItemMapper.toEntity(dto, cart, product));
        }

    }

    public CartItemResponseDTO showById(long id){
        return CartItemMapper.toDTO(cartItemRepository.findById(id).orElseThrow(() -> new RuntimeException ("Item não encontrado")));
    }
    
    public List<CartItemResponseDTO> list(long cart_id){
        Cart cart = cartRepository.findById(cart_id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        return cartItemRepository.findAllByCart(cart).stream().map(CartItemMapper::toDTO).toList();
    }

    public void updateItem(CartItemUpdateDTO cartItemUpdateDTO){
        CartItem item = cartItemRepository.findById(cartItemUpdateDTO.id())
        .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        if(cartItemUpdateDTO.cart_id() != item.getCart().getId()){
            throw new RuntimeException("Acesso negado: os carrinhos não são os mesmos");
        }

        Cart cart = cartRepository.findById(cartItemUpdateDTO.cart_id())
            .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        Product product = productRepository.findById(cartItemUpdateDTO.product_id())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(cartItemUpdateDTO.quantity());

        cartItemRepository.save(item);

    }

    public void deleteItem(long id){
        CartItem item = cartItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
        cartItemRepository.delete(item);
    }

    
}