package br.com.primeshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.ProductVariationCreateDTO;
import br.com.primeshoes.api.dtos.ProductVariationResponseDTO;
import br.com.primeshoes.api.dtos.ProductVariationUpdateDTO;
import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.entites.ProductVariation;
import br.com.primeshoes.api.mappers.ProductVariationMapper;
import br.com.primeshoes.api.repositorys.ProductRepository;
import br.com.primeshoes.api.repositorys.ProductVariationRepository;

@Service
public class ProductVariationService {

	@Autowired
	private ProductVariationRepository productVariationRepository;
	
	private ProductRepository productRepository;
	
	public ProductVariationService(ProductRepository productR) {
		productRepository = productR;
	}
	
	public ProductVariationResponseDTO store(ProductVariationCreateDTO prodVariationCreateDTO) {
		
		Product product = productRepository.findById(prodVariationCreateDTO.productId()).orElseThrow(() -> new RuntimeException("Product not found!"));
		ProductVariation productVariation = ProductVariationMapper.toEntity(prodVariationCreateDTO, product);
		productVariationRepository.save(productVariation);
		
		return show(productVariation.getId());
		
	}
	
	public ProductVariationResponseDTO show(long id) {
		return ProductVariationMapper.toDTO(productVariationRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Variation not found!")));
	}
	
	public List<ProductVariationResponseDTO> list(){
		return productVariationRepository.findAll().stream().map(ProductVariationMapper::toDTO).toList();
	}
	
	public ProductVariationResponseDTO update(ProductVariationUpdateDTO productVariationUpdateDTO) {
		Product product = productRepository.findById(productVariationUpdateDTO.productId()).orElseThrow(() -> new RuntimeException("Product not found!"));
		ProductVariation productVariation = productVariationRepository.findById(productVariationUpdateDTO.id()).orElseThrow(() -> new RuntimeException("Product Variation not found!"));
		
		productVariation.setColor(productVariationUpdateDTO.color());
		productVariation.setProduct(product);
		productVariation.setSize(productVariationUpdateDTO.size());
		productVariation.setStock(productVariationUpdateDTO.stock());
		
		productVariationRepository.save(productVariation);
		
		return show(productVariation.getId());
	}
	
	public void destroy(long id) {
		productVariationRepository.delete(productVariationRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Variation not found!")));
	}
	
}
