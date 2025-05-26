package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.UserCreateDTO;
import br.com.primeshoes.api.dtos.UserResponseDTO;
import br.com.primeshoes.api.entites.User;

public class UserMapper {

	public static User toEntity(UserCreateDTO userCreateDTO) {
		
		User user = new User();
		user.setName(userCreateDTO.name());
		user.setEmail(userCreateDTO.email());
		user.setPassword(userCreateDTO.password());
		user.setRole(userCreateDTO.role());
		
		return user;
		
	}
	
	public static UserResponseDTO toDTO(User user){
		
		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
		
	}
	
}
