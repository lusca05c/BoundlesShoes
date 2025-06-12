package br.com.primeshoes.api.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeshoes.api.dtos.CategoryCreateDTO;
import br.com.primeshoes.api.dtos.CategoryResponseUpdateDTO;
import br.com.primeshoes.api.entites.Category;
import br.com.primeshoes.api.mappers.CategoryMapper;
import br.com.primeshoes.api.repositorys.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
public CategoryResponseUpdateDTO store(CategoryCreateDTO categoryCreateDTO) {
		
		Category category = CategoryMapper.toEntity(categoryCreateDTO);
		
		categoryRepository.save(category);
		
		return showCategory(category.getId());
	}
	
	public CategoryResponseUpdateDTO showCategory(long id) {
		return CategoryMapper.toDTO(categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!")));
	}
	
	public List<CategoryResponseUpdateDTO> listCategories(){
		return categoryRepository.findAll().stream().map(CategoryMapper::toDTO).toList();
	}
	
	public CategoryResponseUpdateDTO update(CategoryResponseUpdateDTO categoryUpdateDTO) {
		
		Category category = categoryRepository.findById(categoryUpdateDTO.id()).orElseThrow(() -> new RuntimeException("Cateogory not found!"));
		category.setName(categoryUpdateDTO.name());
		categoryRepository.save(category);
		
		return CategoryMapper.toDTO(category);
	}
	
	public void destroy(long id) {
		categoryRepository.delete(categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!")));
	}
	
}
