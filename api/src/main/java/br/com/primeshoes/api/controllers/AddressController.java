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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.primeshoes.api.dtos.AddressCreateDTO;
import br.com.primeshoes.api.dtos.AddressResponseDTO;
import br.com.primeshoes.api.dtos.AddressUpdateDTO;
import br.com.primeshoes.api.services.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping
	public ResponseEntity<AddressResponseDTO> createAddress(AddressCreateDTO addressCreateDTO){
		AddressResponseDTO addressResponseDTO = addressService.store(addressCreateDTO);
		return new ResponseEntity<>(addressResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AddressResponseDTO>> listAddresses(){
		return new ResponseEntity<>(addressService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAddressById(@PathVariable long id){
		try {
			AddressResponseDTO addressResponseDTO = addressService.show(id);
			return new ResponseEntity<>(addressResponseDTO, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateAddress(AddressUpdateDTO addressUpdateDTO){
		try {
			AddressResponseDTO addressResponseDTO = addressService.update(addressUpdateDTO);
			return new ResponseEntity<>(addressResponseDTO, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable long id){
		try {
			addressService.destroy(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
