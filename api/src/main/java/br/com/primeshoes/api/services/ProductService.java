package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.primeshoes.api.dtos.ProductCreateDTO;
import br.com.primeshoes.api.dtos.ProductResponseDTO;
import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.mappers.ProductMapper;
import br.com.primeshoes.api.repositorys.ProductRepository;

public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ProductResponseDTO store(ProductCreateDTO productCreateDTO) {
		Product product = ProductMapper.toEntity(productCreateDTO);
		productRepository.save(product);
		return show(product.getId());
	}

	public ProductResponseDTO show(long id) {
		return ProductMapper.toDTO(productRepository.findById(id).orElseThrow(() -> new RuntimeException ("Product Not found!")));
	}
	
	public List<ProductResponseDTO> list(){
		return productRepository.findAll().stream().map(ProductMapper::toDTO).toList();
	}
	
	
	
}
