package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.CategoryResponseUpdateDTO;
import br.com.primeshoes.api.dtos.ProductCreateDTO;
import br.com.primeshoes.api.dtos.ProductResponseDTO;
import br.com.primeshoes.api.dtos.UserResponseDTO;
import br.com.primeshoes.api.entites.Category;
import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.entites.User;


public class ProductMapper {

	public static Product toEntity(ProductCreateDTO productCreateDTO, User user, Category category) {
		
		Product product = new Product();
				product.setName(productCreateDTO.name());
				product.setDescription(productCreateDTO.description());
				product.setPrice(productCreateDTO.price());
				product.setraitingA(productCreateDTO.raitingA());
				product.setUser(user);
				product.setCategory(category);
		
		return product;
		
	}
	
	public static ProductResponseDTO toDTO(Product product) {
		UserResponseDTO user = UserMapper.toDTO(product.getUser());
		CategoryResponseUpdateDTO category = CategoryMapper.toDTO(product.getCategory());
		return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getraitingA(), user, product.getCreated_at(), product.getUpdated_at(), category);
	
	}
	
}