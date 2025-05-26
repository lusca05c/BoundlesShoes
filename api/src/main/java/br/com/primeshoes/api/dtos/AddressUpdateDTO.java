package br.com.primeshoes.api.dtos;

public record AddressUpdateDTO (long id, String street, String city, String state, String zipCode,
		String number, long userId) {

}
