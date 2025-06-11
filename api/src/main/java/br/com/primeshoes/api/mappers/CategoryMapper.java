package br.com.primeshoes.api.mappers;

import br.com.primeshoes.api.dtos.CategoryCreateDTO;

import br.com.primeshoes.api.dtos.CategoryResponseUpdateDTO;
import br.com.primeshoes.api.entites.Category;

public class CategoryMapper {
	
	public static Category toEntity(CategoryCreateDTO categoryCreateDTO) {
		Category category = new Category();
		category.setName(categoryCreateDTO.name());
		
		return category;
	}
	
	public static CategoryResponseUpdateDTO toDTO(Category category) {
		return new CategoryResponseUpdateDTO(category.getId(), category.getName());
	}
	
}
