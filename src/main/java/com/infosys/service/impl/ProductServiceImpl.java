package com.infosys.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.ProductDto;
import com.infosys.exception.ResourceNotFoundException;
import com.infosys.model.Product;
import com.infosys.repository.ProductRepo;
import com.infosys.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductDto createProduct(ProductDto productDto) {

		Product product = this.mapper.map(productDto, Product.class);

		Product save = this.repo.save(product);

		return this.mapper.map(save, ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(ProductDto newProduct, int productId) {

		Product product = this.repo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Id Not Found Server" + productId));

		product.setProductName(newProduct.getProductName());
		product.setProductPrice(newProduct.getProductPrice());
		product.setProductDesc(newProduct.getProductDesc());
		product.setImageName(newProduct.getImageName());
		product.setStock(newProduct.isStock());
		product.setLive(newProduct.isLive());
		
		Product update = this.repo.save(product);

		return this.mapper.map(update, ProductDto.class);
	}

	@Override
	public void deleteProduct(int productId) {

		Product product = this.repo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Id Not Found" + productId));

		this.repo.delete(product);
	}

	@Override
	public ProductDto getProduct(int productId) {

		Product product = this.repo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Product Id.." + productId));

		return this.mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProduct() {

		List<Product> all = this.repo.findAll();

		List<ProductDto> list = all.stream().map(product -> this.mapper.map(product, ProductDto.class))
				.collect(Collectors.toList());

		return list;
	}

}
