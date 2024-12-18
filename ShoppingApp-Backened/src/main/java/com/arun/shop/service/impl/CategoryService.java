package com.arun.shop.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.arun.shop.exception.ResourceNotFoundException;
import com.arun.shop.model.Category;
import com.arun.shop.repository.CategoryRepository;
import com.arun.shop.service.IcategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CategoryService implements IcategoryService {
	private CategoryRepository categoryRepo;

	@Override
	public Category getCategoryById(Long id) {
		Category category = this.categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category is not Present."));
		return category;
	}

	@Override
	public Category getCategoryByName(String name) {
		Category CatName = this.categoryRepo.findByName(name);
		return CatName;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> all = this.categoryRepo.findAll();
		return all;
	}

	@Override
	public Category addCategory(Category cat) {
		Category category = this.categoryRepo.save(cat);
		return category;
	}

	@Override
	public Category updateCategory(Category cat, long id) {
		Category exitCat = this.categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category is not Present."));
		
		exitCat.setName(cat.getName()!=null? cat.getName():exitCat.getName());
		exitCat.setProduct(cat.getProduct()!=null? cat.getProduct():exitCat.getProduct());
		Category save = this.categoryRepo.save(exitCat);
		return save;
	}

	@Override
	public void deleteCategory(long id) {
		Category category = this.categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category is not Present."));
		this.categoryRepo.delete(category);

	}

}
