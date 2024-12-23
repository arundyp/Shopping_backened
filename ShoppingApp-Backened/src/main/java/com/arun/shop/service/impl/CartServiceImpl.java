package com.arun.shop.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.shop.cart.Cart;
import com.arun.shop.exception.ResourceNotFoundException;
import com.arun.shop.repository.CartRepository;
import com.arun.shop.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart getCart(Long id) {
		Cart cart = this.cartRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));

		BigDecimal totalAmount = cart.getTotalAmount();
		cart.setTotalAmount(totalAmount);
		return cart;
	}

	@Override
	public void clearCart(Long id) {
		Cart cart = this.cartRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));
		this.cartRepository.deleteAllByCartId(id);
		cart.getItems().clear();
		this.cartRepository.deleteById(id);

	}

	@Override
	public BigDecimal getTotalPrice(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
