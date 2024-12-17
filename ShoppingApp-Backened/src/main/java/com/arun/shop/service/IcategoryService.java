package com.arun.shop.service;

import java.util.List;

import com.arun.shop.model.Category;

public interface IcategoryService {
	Category getCategoryById(Long id);

	Category getCategoryByName(String name);

	List<Category> getAllCategory();

	Category addCategory(Category cat);

	Category updateCategory(Category cat, long id);

	void deleteCategory(long id);

}
