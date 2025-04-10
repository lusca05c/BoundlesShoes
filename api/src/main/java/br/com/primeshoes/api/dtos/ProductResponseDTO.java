package br.com.primeshoes.api.dtos;

import java.time.Instant;

import br.com.primeshoes.api.entites.User;

public record ProductResponseDTO(
		String name, String description, float price, float raitingA, User user, Instant created_at, Instant updated_at
		) {

}
