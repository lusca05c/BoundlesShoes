package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.AddressCreateDTO;
import br.com.primeshoes.api.dtos.AddressResponseDTO;
import br.com.primeshoes.api.dtos.AddressUpdateDTO;
import br.com.primeshoes.api.entites.Address;
import br.com.primeshoes.api.entites.User;
import br.com.primeshoes.api.mappers.AddressMapper;
import br.com.primeshoes.api.repositorys.AddressRepository;
import br.com.primeshoes.api.repositorys.UserRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public AddressResponseDTO store(AddressCreateDTO addressCreateDTO) {
		User user = userRepository.findById(addressCreateDTO.userId()).orElseThrow(() -> new RuntimeException("Usuário informado não foi encontrado"));
		Address address = AddressMapper.toEntity(addressCreateDTO, user);
		addressRepository.save(address);
		return show(address.getId());
	}
	
	public AddressResponseDTO show(long id) {
		return AddressMapper.toDTO(addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário informado não foi encontrado")));
	}
	
	public List<AddressResponseDTO> list(){
		return addressRepository.findAll().stream().map(AddressMapper::toDTO).toList();
	}
	
	public AddressResponseDTO update(AddressUpdateDTO addressUpdateDTO) {
		
		Address address = addressRepository.findById(addressUpdateDTO.id()).orElseThrow(() -> new RuntimeException("Address not found!"));
		User user = userRepository.findById(addressUpdateDTO.userId()).orElseThrow(() -> new RuntimeException("Usuário informado não foi encontrado"));
		
		address.setCity(addressUpdateDTO.city());
		address.setNumber(addressUpdateDTO.number());
		address.setState(addressUpdateDTO.state());
		address.setStreet(addressUpdateDTO.street());
		address.setUser(user);
		address.setZipCode(addressUpdateDTO.zipCode());
		addressRepository.save(address);
		
		return AddressMapper.toDTO(address);
	}
	
	public void destroy(long id) {
		addressRepository.delete(addressRepository.findById(id).orElseThrow(()-> new RuntimeException ("Address Not found!")));
	}
	
}
