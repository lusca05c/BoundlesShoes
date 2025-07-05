package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.BrandResponseDTO;
import br.com.primeshoes.api.dtos.CategoryResponseUpdateDTO;
import br.com.primeshoes.api.dtos.ImageUpdateResponseDTO;
import br.com.primeshoes.api.dtos.ProductCreateDTO;
import br.com.primeshoes.api.dtos.ProductResponseDTO;
import br.com.primeshoes.api.dtos.UserResponseDTO;
import br.com.primeshoes.api.entites.Brand;
import br.com.primeshoes.api.entites.Category;
import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.entites.User;
import br.com.primeshoes.api.entites.Image;

public class ProductMapper {

	public static Product toEntity(ProductCreateDTO productCreateDTO, User user, Category category, Brand brand, Image image) {
		
		Product product = new Product();
				product.setName(productCreateDTO.name());
				product.setDescription(productCreateDTO.description());
				product.setPrice(productCreateDTO.price());
				product.setraitingA(productCreateDTO.raitingA());
				product.setUser(user);
				product.setCategory(category);
				product.setBrand(brand);
				product.setImage(image);
		
		return product;
		
	}
	
	public static ProductResponseDTO toDTO(Product product) {
		UserResponseDTO user = UserMapper.toDTO(product.getUser());
		CategoryResponseUpdateDTO category = CategoryMapper.toDTO(product.getCategory());
		BrandResponseDTO brand = BrandMapper.toDTO(product.getBrand());
		ImageUpdateResponseDTO image = ImageMapper.toDTO(product.getImage());
		return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getraitingA(), user, product.getCreated_at(), product.getUpdated_at(), category, brand,image);
	
	}
	
}