package br.com.primeshoes.api.dtos;

import java.time.Instant;
import br.com.primeshoes.api.entites.User;

public record AddressResponseDTO (long id, String street, String city, String state, String ZipCode, String number,
		User user, Instant created_at, Instant updated_at) {

}
