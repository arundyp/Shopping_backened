package com.arun.shop.controller;

import org.springframework.web.bind.annotation.RestController;

import com.arun.shop.repository.CategoryRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class CategoryController {
	private CategoryRepository repository;

}
