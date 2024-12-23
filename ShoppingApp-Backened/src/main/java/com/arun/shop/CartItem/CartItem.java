package com.arun.shop.CartItem;

import java.math.BigDecimal;

import com.arun.shop.cart.Cart;
import com.arun.shop.model.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	private int Quantity;

	private BigDecimal unitPrice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	private Cart cart;

}
