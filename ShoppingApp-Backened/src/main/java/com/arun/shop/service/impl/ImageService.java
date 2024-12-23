package com.arun.shop.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arun.shop.DTO.ImageDTO;
import com.arun.shop.exception.ResourceNotFoundException;
import com.arun.shop.model.Image;
import com.arun.shop.model.Product;
import com.arun.shop.repository.ImageRepository;
import com.arun.shop.service.IimageService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ImageService implements IimageService {
	@Autowired
	private ImageRepository imageRepo;
	@Autowired
	private ProductService productService;

	@Override
	public Image getImageById(long id) {
		Image image = this.imageRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Image is not present."));
		return image;
	}

	@Override
	public List<ImageDTO> saveImage(List<MultipartFile> files, long productId) {
		Product product = this.productService.getProductById(productId);
		List<ImageDTO> savedImageDTO = new ArrayList();
		for (MultipartFile file : files) {
			try {

				Image img = new Image();
				img.setFileName(file.getOriginalFilename());
				img.setFileType(file.getContentType());
				img.setImage(new SerialBlob(file.getBytes()));
				img.setProduct(product);
				String buildDownloadurl = "api/v1/images/download/";
				String downloadUrl = buildDownloadurl + img.getId();
				img.setDownload_url(downloadUrl);
				Image savedImage = this.imageRepo.save(img);

				savedImage.setDownload_url(buildDownloadurl + savedImage.getId());
				this.imageRepo.save(savedImage);

				ImageDTO imageDto = new ImageDTO();
				imageDto.setDownloadUrl(savedImage.getDownload_url());
				imageDto.setImageId(savedImage.getId());
				imageDto.setImageName(savedImage.getFileName());
				savedImageDTO.add(imageDto);

			} catch (IOException | SQLException e) {

				throw new RuntimeException(e.getMessage());
			}
		}
		return savedImageDTO;
	}

	@Override
	public List<Image> getAllImage() {
		List<Image> all = this.imageRepo.findAll();
		return all;
	}

	@Override
	public void deleteImage(long id) {
		Image image = this.imageRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Image is not present."));
		this.imageRepo.delete(image);

	}

	@Override
	public void updateImage(MultipartFile file, long image) {
		Image imag = this.imageRepo.findById(image)
				.orElseThrow(() -> new ResourceNotFoundException("Image is not present."));
		try {
			imag.setFileName(file.getOriginalFilename());
			imag.setImage(new SerialBlob(file.getBytes()));

			imag.setFileType(file.getContentType());
			this.imageRepo.save(imag);
		} catch (Exception e) {

		}

	}
}
