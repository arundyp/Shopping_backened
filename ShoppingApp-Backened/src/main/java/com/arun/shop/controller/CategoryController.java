package com.arun.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.shop.model.Category;
import com.arun.shop.response.ApiResponse;
import com.arun.shop.service.impl.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CategoryController {
	private final CategoryService categoryService;

	@GetMapping("/all")
	public ResponseEntity<ApiResponse> getAllCategories() {

		try {
			List<Category> allCategory = this.categoryService.getAllCategory();
			return ResponseEntity.ok(new ApiResponse("Found sucess", allCategory));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse("Error ", HttpStatus.INTERNAL_SERVER_ERROR));

		}

	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addcategory(@RequestBody Category cat) {

		try {
			Category category = this.categoryService.addCategory(cat);
			return ResponseEntity.ok(new ApiResponse("saved sucessfully", category));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

		}

	}

	@GetMapping("/category/{catId}/cat")
	public ResponseEntity<ApiResponse> getCategoryById(@PathVariable long catId) {

		try {
			Category category = this.categoryService.getCategoryById(catId);
			return ResponseEntity.ok(new ApiResponse("found sucessfully", category));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

		}

	}

	@GetMapping("/category/{name}/name")
	public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable String name) {

		try {
			Category category = this.categoryService.getCategoryByName(name);
			return ResponseEntity.ok(new ApiResponse("found sucessfully", category));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

		}

	}

	@GetMapping("/category/{id}/delete")
	public ResponseEntity<ApiResponse> deletecategory(@PathVariable long id) {

		try {
			this.categoryService.deleteCategory(id);
			return ResponseEntity.ok(new ApiResponse("delete sucessfully", null));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

		}

	}

	@GetMapping("/category/{id}/update")
	public ResponseEntity<ApiResponse> updateCategory(@RequestBody Category cat, @PathVariable long id) {

		try {
			Category updateCategory = this.categoryService.updateCategory(cat, id);
			return ResponseEntity.ok(new ApiResponse("Updated sucessfully", updateCategory));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));

		}

	}

}
