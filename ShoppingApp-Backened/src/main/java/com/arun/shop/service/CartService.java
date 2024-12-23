package com.arun.shop.service;

import java.math.BigDecimal;

import com.arun.shop.cart.Cart;

public interface CartService {
	Cart getCart(Long id);
	void clearCart(Long id);
	BigDecimal getTotalPrice(Long id);

}
