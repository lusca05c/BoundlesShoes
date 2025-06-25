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

import br.com.primeshoes.api.dtos.ProductVariationCreateDTO;
import br.com.primeshoes.api.dtos.ProductVariationResponseDTO;
import br.com.primeshoes.api.dtos.ProductVariationUpdateDTO;
import br.com.primeshoes.api.services.ProductVariationService;

@RestController
@RequestMapping("/api/productVariations")
public class ProductVariationController {

	@Autowired
	ProductVariationService productVariationService;
	
	@PostMapping
	public ResponseEntity<ProductVariationResponseDTO> createProductVariation(@RequestBody ProductVariationCreateDTO productVariationCreateDTO){
		ProductVariationResponseDTO productVResponseDTO = productVariationService.store(productVariationCreateDTO);
		return new ResponseEntity<>(productVResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductVariationResponseDTO>> listProductVariations(){
		return new ResponseEntity<>(productVariationService.list(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductVariationById(@PathVariable long id){
		try {
			ProductVariationResponseDTO productVariationResponseDTO = productVariationService.show(id);
			return new ResponseEntity<>(productVariationResponseDTO, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateProductVariation(@RequestBody ProductVariationUpdateDTO productVariationUpdateDTO){
		try {
			ProductVariationResponseDTO productVariationResponseDTO = productVariationService.update(productVariationUpdateDTO);
			return new ResponseEntity<>(productVariationResponseDTO, HttpStatus.OK);
		}catch(RuntimeException e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductVariation(@PathVariable long id){
		try {
			productVariationService.destroy(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
