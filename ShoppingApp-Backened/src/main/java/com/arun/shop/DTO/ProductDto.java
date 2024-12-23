package com.arun.shop.DTO;

import java.math.BigDecimal;
import java.util.List;

import com.arun.shop.model.Category;

import lombok.Data;

@Data
public class ProductDto {

	private String name;
	private String description;
	private String brand;
	private BigDecimal price;
	private Integer inventory;

	private Category category;

	private List<ImageDTO> image;

}
