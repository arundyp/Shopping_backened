package com.arun.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arun.shop.DTO.ProductDto;
import com.arun.shop.model.Product;
import com.arun.shop.response.ApiResponse;
import com.arun.shop.service.impl.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductController {

	private final ProductService productService;

	@GetMapping("/getAll")
	public ResponseEntity<ApiResponse> getAllProduct() {

		try {
			List<Product> allProduct = this.productService.getAllProduct();
			List<ProductDto> convertedProductDto = this.productService.getConvertedProductDto(allProduct);
			if(allProduct.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No data found", null));
			}
			return ResponseEntity.ok(new ApiResponse("found", convertedProductDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}
	}

	@GetMapping("/prod/{productId}")
	public ResponseEntity<ApiResponse> getProductById(@PathVariable long productId) {

		try {
			Product productById = this.productService.getProductById(productId);
			ProductDto convertToDto = this.productService.convertToDto(productById);
			return ResponseEntity.ok(new ApiResponse("found", convertToDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}
	}

	@PostMapping("/prod/add")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody Product prod) {

		try {
			Product product = this.productService.addProduct(prod);
			
			
			return ResponseEntity.ok(new ApiResponse("Saved sucessfully ", product));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}
	}

	@GetMapping("/prod/update/{productId}")
	public ResponseEntity<ApiResponse> updateProduct(@RequestBody Product prod, @PathVariable long productId) {

		try {
			Product product = this.productService.updateProduct(prod, productId);
			return ResponseEntity.ok(new ApiResponse("Updated sucessfully ", product));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}
	}

	@GetMapping("/prod/{productId}/delete")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable long productId) {

		try {
			this.productService.deleteProductById(productId);
			return ResponseEntity.ok(new ApiResponse("Product Deleted sucessfullu", null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}
	}

	@GetMapping("/prod/{name}/name/{brand}/brand")
	public ResponseEntity<ApiResponse> getProductByBrandAndName(@PathVariable String name, @PathVariable String brand) {

		try {
			List<Product> productsByBrandAndName = this.productService.getProductsByBrandAndName(brand, name);
			if (productsByBrandAndName.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No product found ", null));
			}
			return ResponseEntity.ok(new ApiResponse("Found Brand and Name", productsByBrandAndName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}

	}

	@GetMapping("/prod/CatbyBrand")
	public ResponseEntity<ApiResponse> getProductByCategoryAndBrand(@RequestParam String category,
			@RequestParam String brand) {

		try {
			List<Product> productsByBrandAndName = this.productService.getProductsByCategoryAndBrand(category, brand);
			if (productsByBrandAndName.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No product found ", null));
			}
			return ResponseEntity.ok(new ApiResponse("Sucess", productsByBrandAndName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}

	}
	
	
	
	@GetMapping("/prod/{name}/name")
	public ResponseEntity<ApiResponse> getProductByName(@PathVariable String name) {

		try {
			List<Product> productsByBrandAndName = this.productService.getProductsByName(name);
			if (productsByBrandAndName.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No product found ", null));
			}
			return ResponseEntity.ok(new ApiResponse("sucess", productsByBrandAndName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}

	}
	
	
	@GetMapping("/prod/{Brand}/brand")
	public ResponseEntity<ApiResponse> getProductByBrand(@PathVariable String Brand) {

		try {
			List<Product> productsByBrandAndName = this.productService.getProductsByBrand(Brand);
			if (productsByBrandAndName.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No product found ", null));
			}
			return ResponseEntity.ok(new ApiResponse("sucess", productsByBrandAndName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}

	}
	
	
	@GetMapping("/prod/{category}/Category")
	public ResponseEntity<ApiResponse> getProductByCategory(@PathVariable String category) {

		try {
			List<Product> productsByBrandAndName = this.productService.getProductsByCategory(category);
			if (productsByBrandAndName.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No product found ", null));
			}
			return ResponseEntity.ok(new ApiResponse("Sucess", productsByBrandAndName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
