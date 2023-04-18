package com.godoro.inventorycontrol.businness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.inventorycontrol.data.entity.Cart;
import com.godoro.inventorycontrol.data.entity.CartProduct;
import com.godoro.inventorycontrol.data.entity.CartStatus;
import com.godoro.inventorycontrol.data.entity.Product;
import com.godoro.inventorycontrol.data.repository.CartProductRepository;
import com.godoro.inventorycontrol.data.repository.CartRepository;
import com.godoro.inventorycontrol.data.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    public Optional<Cart> getCartById(Long id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        return cartOptional;
    }

    
        
    

    public Cart addProductToCart(Long cartId, Long productId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Optional<Product> productOptional = productRepository.findById(productId);
        if (cartOptional.isPresent() && productOptional.isPresent()) {
            Cart cart = cartOptional.get();
            Product product = productOptional.get();
            CartProduct cartProduct = new CartProduct();
            cartProduct.setProduct(product);
            cartProduct.setCart(cart);
            cartProduct.setSalesQuantity(cartProduct.getSalesQuantity()+1);
            cartProductRepository.save(cartProduct);
            cart.getCartProducts().add(cartProduct);
            
            return cart;
        } else {
            throw new RuntimeException("Cart or Product not found");
        }
    }

    public Cart removeProductFromCart(Long cartId, Long productId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Optional<Product> productOptional = productRepository.findById(productId);
        if (cartOptional.isPresent() && productOptional.isPresent()) {
            Cart cart = cartOptional.get();
            Product product = productOptional.get();
            List<CartProduct> cartProducts = cartProductRepository.findByCartAndProduct(cart, product);
            if (cartProducts.size() > 0) {
                CartProduct cartProduct = cartProducts.get(0);
                cartProductRepository.delete(cartProduct);
                cart.getCartProducts().remove(cartProduct);
                cartProduct.setSalesQuantity(cartProduct.getSalesQuantity()-1);
                return cart;
            } else {
                throw new RuntimeException("Product not found in Cart");
            }
        } else {
            throw new RuntimeException("Cart or Product not found");
        }
    }


    public void checkoutCart(Cart cart) {
        cart.setStatus(CartStatus.CHECKED_OUT);
        cartRepository.save(cart);
    }





	public Cart addObjectProductToCart(Long cartId, Product product) {
		long id= product.getProductId();	
		  Optional<Cart> cartOptional = cartRepository.findById(cartId);
	        Optional<Product> productOptional = productRepository.findById(id);
	        if (cartOptional.isPresent() && productOptional.isPresent()) {
	            Cart cart = cartOptional.get();
	            Product product1 = productOptional.get();
	            CartProduct cartProduct = new CartProduct();
	            cartProduct.setProduct(product1);
	            cartProduct.setCart(cart);
	            cartProduct.setSalesQuantity(cartProduct.getSalesQuantity()+1);
	            cartProductRepository.save(cartProduct);
	            cart.getCartProducts().add(cartProduct);
	            
	            return cart;
	        } else {
	            throw new RuntimeException("Cart or Product not found");
	        }
	
	}





	public void saveCart(Cart cart) {
		cartRepository.save(cart);
		
	}


	 public Cart updateCart(Cart updatedCart) {
	        Optional<Cart> optionalCart = cartRepository.findById(updatedCart.getId());
	        if (optionalCart.isPresent()) {
	            Cart cart = optionalCart.get();
	            cart.setStatus(CartStatus.CHECKED_OUT);
	            
	            return cartRepository.save(cart);
	        } else {
	        	throw new RuntimeException("Cart not found");
	        }
	    }


	
	

	
}