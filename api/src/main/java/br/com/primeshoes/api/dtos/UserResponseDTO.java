package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.enuns.Role;

public record UserResponseDTO (long id, String name, String email, Role role) {
	
}
