package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.entites.User;

public record ProductCreateDTO (String name, String description, float price, float raitingA, User user){

}
