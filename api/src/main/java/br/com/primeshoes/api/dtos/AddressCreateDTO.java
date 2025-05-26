package br.com.primeshoes.api.dtos;

public record AddressCreateDTO (String street, String city, String state, String zipCode, String number, long userId) {

}
