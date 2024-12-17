package com.arun.shop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.arun.shop.model.Image;

public interface IimageService {
	Image getImageById(long id);
	Image saveImage(Image img);
	List<Image> getAllImage();
	void deleteImage(long id);
	void updateImage(MultipartFile img, long id);
	

}
