package com.arun.shop.service.impl;

import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arun.shop.exception.ResourceNotFoundException;
import com.arun.shop.model.Image;
import com.arun.shop.repository.ImageRepository;
import com.arun.shop.repository.productRepository;
import com.arun.shop.service.IimageService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ImageServiceImpl implements IimageService {
	private ImageRepository imageRepo;
	private productRepository productRepository;

	@Override
	public Image getImageById(long id) {
		Image image = this.imageRepo.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Image is not present."));
		return image;
	}

	@Override
	public Image saveImage(Image img) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> getAllImage() {
		List<Image> all = this.imageRepo.findAll();
		return all;
	}

	@Override
	public void deleteImage(long id) {
		Image image = this.imageRepo.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Image is not present."));
		this.imageRepo.delete(image);
		
	}

	@Override
	public void updateImage(MultipartFile file, long id) {
		Image imag = this.imageRepo.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Image is not present."));
		try {
			imag.setFileName(file.getOriginalFilename());
			imag.setImage(new SerialBlob(file.getBytes()));
			this.imageRepo.save(imag);
		}
		catch(Exception e){
			
		}
		
	}}
