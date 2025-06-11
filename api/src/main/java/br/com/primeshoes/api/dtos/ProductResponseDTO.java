package br.com.primeshoes.api.dtos;

import java.time.Instant;

public record ProductResponseDTO(long id,
		String name, String description, float price, float raitingA, UserResponseDTO user, Instant created_at,
		Instant updated_at, CategoryResponseUpdateDTO category) {

}