package br.com.primeshoes.api.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.ProductCreateDTO;
import br.com.primeshoes.api.dtos.ProductResponseDTO;
import br.com.primeshoes.api.dtos.ProductUpdateDTO;
import br.com.primeshoes.api.entites.Category;
import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.entites.User;
import br.com.primeshoes.api.enuns.Role;
import br.com.primeshoes.api.mappers.ProductMapper;
import br.com.primeshoes.api.repositorys.CategoryRepository;
import br.com.primeshoes.api.repositorys.ProductRepository;
import br.com.primeshoes.api.repositorys.UserRepository;

@Service
public class ProductService {

	
    private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	private CategoryRepository categoryRepository;
	
	public ProductService (UserRepository userRc, CategoryRepository categoryRc) {
		userRepository = userRc;
		categoryRepository = categoryRc;
	}
	
	public ProductResponseDTO store(ProductCreateDTO productCreateDTO) {
		User user = userRepository.findById(productCreateDTO.user_id()).orElseThrow(() -> new RuntimeException("Usuário informado não foi encontrado"));
		Category category = categoryRepository.findById(productCreateDTO.category_id()).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
		
		if(user.getRole() != Role.BUYER) {
			return null;
		}
		Product product = ProductMapper.toEntity(productCreateDTO, user, category);
		productRepository.save(product);
		return show(product.getId());
	}

	public ProductResponseDTO show(long id) {
		return ProductMapper.toDTO(productRepository.findById(id).orElseThrow(() -> new RuntimeException ("Product Not found!")));
	}
	
	public List<ProductResponseDTO> list(){
		return productRepository.findAll().stream().map(ProductMapper::toDTO).toList();
	}
	
	public ProductResponseDTO update(ProductUpdateDTO productUpdateDTO) {
		
		Product product = productRepository.findById(productUpdateDTO.id()).orElseThrow(() -> new RuntimeException("Product not found!"));
		User user = userRepository.findById(productUpdateDTO.user_id()).orElseThrow(() -> new RuntimeException("User not found!"));
		Category category = categoryRepository.findById(productUpdateDTO.category_id()).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
		
		product.setName(productUpdateDTO.name());
		product.setPrice(productUpdateDTO.price());
		product.setraitingA(productUpdateDTO.raitingA());
		product.setDescription(productUpdateDTO.description());
		product.setUser(user);
		product.setCategory(category);
		productRepository.save(product);
		
		return ProductMapper.toDTO(product);
	}
	
	public void destroy(long id) {
		productRepository.delete(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found")));
	}
	
	
	
	
	
}
