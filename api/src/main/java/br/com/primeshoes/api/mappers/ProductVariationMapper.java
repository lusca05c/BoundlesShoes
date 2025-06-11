package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.ProductResponseDTO;
import br.com.primeshoes.api.dtos.ProductVariationCreateDTO;
import br.com.primeshoes.api.dtos.ProductVariationResponseDTO;
import br.com.primeshoes.api.entites.Product;
import br.com.primeshoes.api.entites.ProductVariation;

public class ProductVariationMapper {

	public static ProductVariation toEntity(ProductVariationCreateDTO prodVariationCreateDTO, Product product) {
		
		ProductVariation productVariation = new ProductVariation();
		productVariation.setColor(prodVariationCreateDTO.color());
		productVariation.setSize(prodVariationCreateDTO.size());
		productVariation.setStock(prodVariationCreateDTO.stock());
		productVariation.setProduct(product);
		
		return productVariation;
	}
	
	public static ProductVariationResponseDTO toDTO(ProductVariation productVariation) {
		ProductResponseDTO product = ProductMapper.toDTO(productVariation.getProduct());
		return new ProductVariationResponseDTO(productVariation.getId(), productVariation.getColor(), productVariation.getSize(), productVariation.getStock(), product);
	}
	
}
