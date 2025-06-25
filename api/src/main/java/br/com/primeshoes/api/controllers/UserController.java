package br.com.primeshoes.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.primeshoes.api.dtos.UserCreateDTO;
import br.com.primeshoes.api.dtos.UserResponseDTO;
import br.com.primeshoes.api.dtos.UserUpdateDTO;
import br.com.primeshoes.api.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        UserResponseDTO userResponseDTO = userService.store(userCreateDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> listUsers(){
		return new ResponseEntity<>(userService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable long id){
		try{
			UserResponseDTO userResponseDTO = userService.show(id);
	        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
		}catch (RuntimeException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody UserUpdateDTO userUpdateDTO){
		try {
			UserResponseDTO userResponseDTO = userService.update(userUpdateDTO);
			return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
		} catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id){
		try {
			userService.destroy(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
	}

	
}
