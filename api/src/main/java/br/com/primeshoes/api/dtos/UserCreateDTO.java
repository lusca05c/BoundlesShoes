package br.com.primeshoes.api.dtos;

import br.com.primeshoes.api.enuns.Role;

public record UserCreateDTO(String name, String email, String password, Role role) {

}
