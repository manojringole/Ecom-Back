package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.ProductDto;
import com.infosys.payload.ApiResponse;
import com.infosys.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductService service;
	
	
	@PostMapping("/")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto){
		
		ProductDto createProduct = service.createProduct(dto);
		return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto dto, @PathVariable int productId){
		
		ProductDto update = service.updateProduct(dto, productId);
		
		return new ResponseEntity<ProductDto>(update,HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable int productId){
		
		ProductDto product = service.getProduct(productId);
		return new ResponseEntity<ProductDto>(product,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> allProduct(){
		
		List<ProductDto> allProduct = service.getAllProduct();
		return new ResponseEntity<List<ProductDto>>(allProduct,HttpStatus.OK);

	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int productId){
		
		service.deleteProduct(productId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully ", true) ,HttpStatus.OK);
	}
}

