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

import br.com.primeshoes.api.dtos.BrandCreateDTO;
import br.com.primeshoes.api.dtos.BrandResponseDTO;
import br.com.primeshoes.api.dtos.BrandUpdateDTO;
import br.com.primeshoes.api.services.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@PostMapping
	public ResponseEntity<BrandResponseDTO> createBrand(@RequestBody BrandCreateDTO brandCreateDTO){
		BrandResponseDTO brandResponseDTO = brandService.store(brandCreateDTO);
		return new ResponseEntity<>(brandResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BrandResponseDTO>> list(){
		return new ResponseEntity<>(brandService.listBrands(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBrandById(@PathVariable long id){
		try {
			BrandResponseDTO brandResponseDTO = brandService.showBrand(id);
			return new ResponseEntity<>(brandResponseDTO, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateBrand(@RequestBody BrandUpdateDTO brandUpdateDTO){
		try {
			BrandResponseDTO brandResponseDTO = brandService.updateBrand(brandUpdateDTO);
			return new ResponseEntity<>(brandResponseDTO, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> destroyBrand(@PathVariable long id){
		try {
			brandService.destroy(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
