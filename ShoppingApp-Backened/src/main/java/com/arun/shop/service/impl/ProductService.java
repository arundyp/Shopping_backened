package com.arun.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.arun.shop.exception.ResourceNotFoundException;
import com.arun.shop.model.Product;
import com.arun.shop.repository.productRepository;
import com.arun.shop.service.IproductService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProductService implements IproductService {
	@Autowired
	private productRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		Product save = this.productRepository.save(product);
		return save;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> all = this.productRepository.findAll();
		return all;
	}

	@Override
	public Product getProductById(Long id) {
		Product product = this.productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product is not found"));
		return product;
	}

	@Override
	public void deleteProductById(Long id) {
		Product product = this.productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product is not found"));
		this.productRepository.delete(product);

	}

	@Override
	public Product updateProduct(Product prod, long id) {
		Product exitprod = this.productRepository.findById(id).get();
		exitprod.setName(prod.getName() != null ? prod.getName() : exitprod.getName());
		exitprod.setBrand(prod.getBrand() != null ? prod.getBrand() : exitprod.getBrand());
		exitprod.setCategory(prod.getCategory() != null ? prod.getCategory() : exitprod.getCategory());
		exitprod.setDescription(prod.getDescription() != null ? prod.getDescription() : exitprod.getDescription());
		exitprod.setImage(prod.getImage() != null ? prod.getImage() : exitprod.getImage());
		exitprod.setInventory(prod.getInventory() != null ? prod.getInventory() : exitprod.getInventory());
		exitprod.setPrice(prod.getPrice() != null ? prod.getPrice() : exitprod.getPrice());

		Product product = this.productRepository.save(exitprod);
		return product;

	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> byCategoryName = this.productRepository.findByCategoryName(category);
		return byCategoryName;
	}

	@Override
	public List<Product> getProductsByBrand(String brand) {
		List<Product> byBrand = this.productRepository.findByBrand(brand);
		return byBrand;
	}

	@Override
	public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
		List<Product> prod = this.productRepository.findByCategoryNameAndBrand(category, brand);
		return prod;
	}

	@Override
	public List<Product> getProductsByName(String name) {
		List<Product> prod = this.productRepository.findByName(name);
		return prod;
	}

	@Override
	public List<Product> getProductsByBrandAndName(String brand, String name) {
		List<Product> prod = this.productRepository.findByBrandAndName(brand, name);
		return prod;
	}

	@Override
	public Long countProductsByBrandAndName(String brand, String name) {
		long countByBrandAndName = this.productRepository.countByBrandAndName(brand, name);
		return countByBrandAndName;
	}

}
