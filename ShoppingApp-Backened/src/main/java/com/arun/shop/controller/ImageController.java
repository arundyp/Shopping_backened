package com.arun.shop.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arun.shop.DTO.ImageDTO;
import com.arun.shop.model.Image;
import com.arun.shop.response.ApiResponse;
import com.arun.shop.service.impl.ImageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ImageController {
	private final ImageService imageService;

	@GetMapping("/image/upload")
	public ResponseEntity<ApiResponse> saveimage(@RequestParam List<MultipartFile> file, @RequestParam long productid) {

		try {
			List<ImageDTO> saveImage = this.imageService.saveImage(file, productid);
			return ResponseEntity.ok(new ApiResponse("upload sucess", saveImage));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse("failed to save", null));
		}
	}

	@GetMapping("/image/download/{imageId}")
	public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable Long imageId) throws SQLException {
		Image image = this.imageService.getImageById(imageId);
		ByteArrayResource resource = new ByteArrayResource(
				image.getImage().getBytes(1, (int) image.getImage().length()));

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + image.getFileName() + "\" ")
				.body(resource);

	}

	@PutMapping("/image/{imageId}/update")
	public ResponseEntity<ApiResponse> updateImage(@RequestBody MultipartFile file,@PathVariable Long imageId) {

		try {
			Image image = this.imageService.getImageById(imageId);
			if (image != null) {
				this.imageService.updateImage(file, image.getId());

				return ResponseEntity.ok(new ApiResponse("upload sucess", null));
			}
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse("Upload failed", HttpStatus.INTERNAL_SERVER_ERROR));

	}
	
	@PutMapping("/image/{imageId}/delete")
	public ResponseEntity<ApiResponse> deleteImage(@PathVariable Long imageId) {

		try {
			Image image = this.imageService.getImageById(imageId);
			if (image != null) {
				this.imageService.deleteImage(imageId);

				return ResponseEntity.ok(new ApiResponse("Delete sucess", null));
			}
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse("Delete failed", HttpStatus.INTERNAL_SERVER_ERROR));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
