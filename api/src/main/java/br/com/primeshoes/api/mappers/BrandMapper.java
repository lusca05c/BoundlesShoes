package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.BrandCreateDTO;
import br.com.primeshoes.api.dtos.BrandResponseDTO;
import br.com.primeshoes.api.entites.Brand;

public class BrandMapper {

	
	public static Brand toEntity(BrandCreateDTO brandCreateDTO) {
		
		Brand brand = new Brand();
		brand.setName(brandCreateDTO.name());
		return brand;
		
	}
	
	public static BrandResponseDTO toDTO(Brand brand) {
		return new BrandResponseDTO(brand.getId(), brand.getName());
		
	}
	
}
