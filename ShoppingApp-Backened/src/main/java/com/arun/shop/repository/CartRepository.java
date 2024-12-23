package com.arun.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.shop.cart.Cart;

public interface CartRepository  extends JpaRepository<Cart, Long>{

	void deleteAllByCartId(Long id);

}
