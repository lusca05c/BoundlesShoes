package br.com.primeshoes.api.dtos;

public record CartItemResponseDTO(long id, CartResponseDTO cart, ProductResponseDTO product, int quantity) {
    
}
