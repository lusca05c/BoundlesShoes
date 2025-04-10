package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.ProductCreateDTO;
import br.com.primeshoes.api.dtos.ProductResponseDTO;
import br.com.primeshoes.api.entites.Product;
public class ProductMapper {

	public static Product toEntity(ProductCreateDTO productCreateDTO) {
		
		Product product = new Product();
				product.setName(productCreateDTO.name());
				product.setDescription(productCreateDTO.description());
				product.setPrice(productCreateDTO.price());
				product.setraitingA(productCreateDTO.raitingA());
				product.setUser(productCreateDTO.user());
		
		return product;
		
	}
	
	public static ProductResponseDTO toDTO(Product product) {
		
		
		
		return new ProductResponseDTO(product.getName(), product.getDescription(), product.getPrice(), product.getraitingA(), product.getUser(), product.getCreated_at(), product.getUpdated_at());
	}
	
}
