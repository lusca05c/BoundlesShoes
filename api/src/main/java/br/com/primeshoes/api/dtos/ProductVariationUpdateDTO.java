package br.com.primeshoes.api.dtos;

public record ProductVariationUpdateDTO (long id, String color, String size, long stock, long productId) {

}
