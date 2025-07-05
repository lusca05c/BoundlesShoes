package br.com.primeshoes.api.dtos;

public record ProductUpdateDTO (long id, String name, String description, float price, float raitingA, long user_id,
		long category_id, long brand_id, long image_id){

}
