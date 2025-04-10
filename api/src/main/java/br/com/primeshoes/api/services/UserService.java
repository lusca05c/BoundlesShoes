package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.UserCreateDTO;
import br.com.primeshoes.api.dtos.UserResponseDTO;
import br.com.primeshoes.api.dtos.UserUpdateDTO;
import br.com.primeshoes.api.entites.User;
import br.com.primeshoes.api.mappers.UserMapper;
import br.com.primeshoes.api.repositorys.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserResponseDTO store(UserCreateDTO userCreateDTO) {
		User user = UserMapper.toEntity(userCreateDTO);
		userRepository.save(user);
		return show(user.getId());
	}
	
	public List<UserResponseDTO> list() {
		return userRepository.findAll().stream().map(UserMapper::toDTO).toList();
	}
	
	public UserResponseDTO update(UserUpdateDTO userUpdateDTO) {
		
		User user = userRepository.findById(userUpdateDTO.id()).orElseThrow(() -> new RuntimeException("User not found!"));
		user.setEmail(userUpdateDTO.email());
		user.setName(userUpdateDTO.name());
		user.setPassword(userUpdateDTO.password());
		user.setRole(userUpdateDTO.role());
		
		userRepository.save(user);
		
		return UserMapper.toDTO(user);
	}
	
	public UserResponseDTO show(long id) {
		return UserMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!")));
	}
	
	public void destroy(long id){
		
		userRepository.delete(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!")));
		
	}
	
}
