package com.infosys.service;

import java.util.List;

import com.infosys.dto.ProductDto;

public interface ProductService {

	
	public ProductDto createProduct(ProductDto productDto);
	
	public ProductDto updateProduct(ProductDto newProduct, int productId);
	
	public void deleteProduct(int productId);
	
	public ProductDto getProduct(int productId);
	
	public List<ProductDto> getAllProduct();
}
