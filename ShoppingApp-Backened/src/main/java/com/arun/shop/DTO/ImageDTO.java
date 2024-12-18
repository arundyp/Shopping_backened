package com.arun.shop.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
	private long imageId;
	private String imageName;
	private String downloadUrl;
	

}
