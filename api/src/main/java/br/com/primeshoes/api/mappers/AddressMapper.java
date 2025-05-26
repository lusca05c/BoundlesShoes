package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.AddressCreateDTO;
import br.com.primeshoes.api.dtos.AddressResponseDTO;
import br.com.primeshoes.api.entites.Address;
import br.com.primeshoes.api.entites.User;

public class AddressMapper {

	public static Address toEntity(AddressCreateDTO addressCreateDTO, User user){
		
		Address address = new Address();
		
		address.setStreet(addressCreateDTO.street());
		address.setNumber(addressCreateDTO.number());
		address.setCity(addressCreateDTO.city());
		address.setState(addressCreateDTO.state());
		address.setZipCode(addressCreateDTO.zipCode());
		address.setUser(user);
		
		return address;
	}
	
	public static AddressResponseDTO toDTO(Address address) {
		
		return new AddressResponseDTO(address.getId(), address.getStreet(), address.getCity(), address.getState(),
				address.getZipCode(), address.getNumber(), address.getUser(), address.getCreated_at(), address.getUpdated_at());
		
	}
	
}
