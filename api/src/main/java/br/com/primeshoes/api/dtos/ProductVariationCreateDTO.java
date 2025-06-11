package br.com.primeshoes.api.dtos;

public record ProductVariationCreateDTO (String color, String size, long stock, long productId) {

}
