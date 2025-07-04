package br.com.primeshoes.api.dtos;

public record CartItemCreateDTO(long cart_id, long product_id, int quantity) {
    
}
