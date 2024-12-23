package com.arun.shop.service;

public interface CartItemService {
	void addItemToCart(Long cartId, Long productId,int Quantity);
	void removeItemfromCart(Long cartId,Long productId);
	Void updateItemQuantity(Long cartId,Long productId,int quantity);

}
