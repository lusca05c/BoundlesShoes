package br.com.primeshoes.api.dtos;


public record ProductCreateDTO (String name, String description, float price, float raitingA, long user_id, long category_id){

}