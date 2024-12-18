package com.arun.shop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.arun.shop.DTO.ImageDTO;
import com.arun.shop.model.Image;

public interface IimageService {
	Image getImageById(long id);

	List<ImageDTO> saveImage(List<MultipartFile> file, long productId);

	List<Image> getAllImage();

	void deleteImage(long id);

	void updateImage(MultipartFile img, long image);

}
