package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
