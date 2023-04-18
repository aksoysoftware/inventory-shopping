package com.godoro.inventorycontrol.data.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<CartProduct> cartProducts;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private CartStatus status;

    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Cart(Long id, List<CartProduct> cartProducts, BigDecimal totalAmount, CartStatus status, User user) {
		super();
		this.id = (long) 7;
		this.cartProducts = cartProducts;
		this.totalAmount = totalAmount;
		this.status = status;
		this.user = user;
	}

	
	public Cart() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	 @Override
	    public String toString() {
	        return "Cart [id=" + id + ", status=" + status + "]";
	    }

	   
	    public List<CartProduct> getCartProductsWithoutCart() {
	        List<CartProduct> result = new ArrayList<>();
	        for (CartProduct cartProduct : cartProducts) {
	            CartProduct cp = new CartProduct();
	            cp.setId(cartProduct.getId());
	            cp.setSalesQuantity(cartProduct.getSalesQuantity());
	            cp.setProduct(cartProduct.getProduct());
	            result.add(cp);
	        }
	        return result;
	    }

}
