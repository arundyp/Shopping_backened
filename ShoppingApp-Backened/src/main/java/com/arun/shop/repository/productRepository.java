package com.arun.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.shop.model.Product;

public interface productRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategoryName(String category);

	List<Product> findByCategoryNameAndBrand(String category, String brand);

	List<Product> findByName(String name);

	List<Product> findByBrandAndName(String brand, String name);

	long  countByBrandAndName(String brand, String name);

	List<Product> findByBrand(String brand);

}
