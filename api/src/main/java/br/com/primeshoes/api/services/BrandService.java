package br.com.primeshoes.api.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.entites.Brand;
import br.com.primeshoes.api.dtos.BrandCreateDTO;
import br.com.primeshoes.api.dtos.BrandResponseDTO;
import br.com.primeshoes.api.dtos.BrandUpdateDTO;
import br.com.primeshoes.api.mappers.BrandMapper;
import br.com.primeshoes.api.repositorys.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	public BrandResponseDTO store(BrandCreateDTO brandCreateDTO) {
		Brand brand = BrandMapper.toEntity(brandCreateDTO);
		
		brandRepository.save(brand);
		
		return showBrand(brand.getId());
	}
	
	public BrandResponseDTO showBrand(long id) {
		return BrandMapper.toDTO(brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found!")));
	}
	
	public List<BrandResponseDTO> listBrands(){
		return brandRepository.findAll().stream().map(BrandMapper::toDTO).toList();
	}
	
	public BrandResponseDTO updateBrand(BrandUpdateDTO brandUpdateDTO) {
		Brand brand  = brandRepository.findById(brandUpdateDTO.id()).orElseThrow(() -> new RuntimeException("Brand not found!"));
		
		brand.setName(brandUpdateDTO.name());
		brandRepository.save(brand);
		
		return showBrand(brand.getId());
	}
	
	public void destroy(long id) {
		brandRepository.delete(brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found!")));
	}
	
}
