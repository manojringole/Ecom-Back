package com.infosys.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.CategoryDto;
import com.infosys.exception.ResourceNotFoundException;
import com.infosys.model.Category;
import com.infosys.repository.CategoryRepository;
import com.infosys.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	@Override
	public CategoryDto create(CategoryDto categoryDto) {
		
		Category category = this.mapper.map(categoryDto, Category.class);
		
		Category save = this.repository.save(category);
		
		return this.mapper.map(save, CategoryDto.class);
	}

	
	@Override
	public CategoryDto update(CategoryDto categoryDto, Integer categoryId) {
		
	 Category category = this.repository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category Id not found server"+categoryId));
		
	 category.setTitle(categoryDto.getTitle());
	 
	 Category update = this.repository.save(category);
	 
	 return this.mapper.map(update, CategoryDto.class);
	}
	
	

	@Override
	public CategoryDto get(Integer categoryId) {
		
		Category category = this.repository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Invalid categoryId..."+categoryId));
		
		return this.mapper.map(category, CategoryDto.class);
	}
	
	

	@Override
	public List<CategoryDto> getAll() {
		
		List<Category> all = this.repository.findAll();
		
		List<CategoryDto> list = all.stream().map(category -> this.mapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public void delete(Integer categoryId) {
		
		Category category = this.repository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Invalid categoryId..."+categoryId));

		this.repository.delete(category);
		
	}

}
