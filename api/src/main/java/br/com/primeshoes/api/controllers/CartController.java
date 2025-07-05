package br.com.primeshoes.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.primeshoes.api.dtos.CartCreateDTO;
import br.com.primeshoes.api.dtos.CartItemCreateDTO;
import br.com.primeshoes.api.dtos.CartItemResponseDTO;
import br.com.primeshoes.api.dtos.CartItemUpdateDTO;
import br.com.primeshoes.api.services.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/createCart")
    public ResponseEntity<?> createCart(@RequestParam long userId) {
        try {
            CartCreateDTO cart = cartService.createCart(userId);
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<?> addItem(@PathVariable long cartId, @RequestBody CartItemCreateDTO dto) {
        try {
            cartService.store(dto, cartId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<?> listItems(@PathVariable long cartId) {
        try {
            List<CartItemResponseDTO> items = cartService.list(cartId);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<?> getItem(@PathVariable long itemId) {
        try {
            CartItemResponseDTO item = cartService.showById(itemId);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/items")
    public ResponseEntity<?> updateItem(@RequestBody CartItemUpdateDTO dto) {
        try {
            cartService.updateItem(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable long itemId) {
        try {
            cartService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
