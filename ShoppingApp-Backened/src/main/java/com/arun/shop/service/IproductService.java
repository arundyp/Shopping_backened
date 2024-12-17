package com.arun.shop.service;

import java.util.List;

import com.arun.shop.model.Product;

public interface IproductService {
	Product addProduct(Product product);

	List<Product> getAllProduct();

	Product getProductById(Long id);

	void deleteProductById(Long id);

	Product updateProduct(Product prod, long id);

	List<Product> getProductsByCategory(String category);

	List<Product> getProductsByBrand(String category);

	List<Product> getProductsByCategoryAndBrand(String category, String brand);

	List<Product> getProductsByName(String name);

	List<Product> getProductsByBrandAndName(String brand, String name);

	Long countProductsByBrandAndName(String brand, String name);

}
