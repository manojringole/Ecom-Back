package com.infosys.service;

import java.util.List;

import com.infosys.dto.CategoryDto;

public interface CategoryService {

	
	public CategoryDto create(CategoryDto categoryDto);
	
	public CategoryDto update(CategoryDto categoryDto,Integer categoryId);
	
	public CategoryDto get(Integer categoryId);
	
	public List<CategoryDto> getAll();
	
	public void delete(Integer categoryId);
}
