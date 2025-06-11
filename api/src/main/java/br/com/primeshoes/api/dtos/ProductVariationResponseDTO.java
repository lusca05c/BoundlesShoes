package br.com.primeshoes.api.dtos;

public record ProductVariationResponseDTO (long id, String color, String size, long stock, ProductResponseDTO product) {

}
