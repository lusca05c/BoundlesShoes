package br.com.primeshoes.api.dtos;

public record CartItemUpdateDTO(long id, long cart_id, long product_id, int quantity) {
    
}
