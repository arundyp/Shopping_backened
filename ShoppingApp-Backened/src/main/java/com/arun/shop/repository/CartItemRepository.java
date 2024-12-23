package com.arun.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.shop.CartItem.CartItem;

public interface CartItemRepository  extends JpaRepository<CartItem,Long>{
	

}
