package com.arun.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.shop.model.Image;

public interface ImageRepository  extends JpaRepository<Image, Long>{

}
