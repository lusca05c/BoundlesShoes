package br.com.primeshoes.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.primeshoes.api.dtos.CategoryCreateDTO;
import br.com.primeshoes.api.dtos.CategoryResponseUpdateDTO;
import br.com.primeshoes.api.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryResponseUpdateDTO> createCategory(@RequestBody CategoryCreateDTO categoryCreateDTO){
		CategoryResponseUpdateDTO categoryResponseDTO = categoryService.store(categoryCreateDTO);
		return new ResponseEntity<>(categoryResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryResponseUpdateDTO>> list(){
		return new ResponseEntity<>(categoryService.listCategories(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable long id){
		try {
			CategoryResponseUpdateDTO categoryResponseDTO = categoryService.showCategory(id);
			return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateCategory(@RequestBody CategoryResponseUpdateDTO categoryUpdateDTO){
		try {
			CategoryResponseUpdateDTO categoryResponseDTO = categoryService.update(categoryUpdateDTO);
			return new ResponseEntity<>(categoryResponseDTO, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable long id){
		try{
			categoryService.destroy(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
