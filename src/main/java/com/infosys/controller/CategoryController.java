package com.infosys.controller;

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

import com.infosys.dto.CategoryDto;
import com.infosys.model.Category;
import com.infosys.payload.ApiResponse;
import com.infosys.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto){
		
		CategoryDto create = categoryService.create(categoryDto);
		
		return new ResponseEntity<CategoryDto>(create,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
		
		CategoryDto update = categoryService.update(categoryDto, categoryId);
		
		return new ResponseEntity<CategoryDto>(update , HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> get(@PathVariable Integer categoryId){
	
		CategoryDto categoryDto = categoryService.get(categoryId);
		
		return new ResponseEntity<CategoryDto>(categoryDto , HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAll(){
	
		List<CategoryDto> all = categoryService.getAll();
		
		return new ResponseEntity<List<CategoryDto>>(all , HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer categoryId){
	
		categoryService.delete(categoryId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("deleted successfully...", true), HttpStatus.OK);
	}
	
	
}
