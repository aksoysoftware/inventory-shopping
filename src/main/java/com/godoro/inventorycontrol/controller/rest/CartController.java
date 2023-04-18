package com.godoro.inventorycontrol.controller.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.inventorycontrol.businness.CartService;
import com.godoro.inventorycontrol.data.entity.Cart;
import com.godoro.inventorycontrol.data.entity.CartStatus;
import com.godoro.inventorycontrol.data.entity.Product;

@RestController
@RequestMapping("api/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;

 
    
    
    @GetMapping("/get/{cartId}")
    public ResponseEntity<?> getCart(@PathVariable("cartId") Long cartId) {
        Optional<Cart> cartOptional = cartService.getCartById(cartId);

        if (!cartOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Cart cart = cartOptional.get();
        cart.setCartProducts(cart.getCartProductsWithoutCart()); 
        return ResponseEntity.ok(cart);
    }
    
    @PostMapping("/add/{cartid}/{productid}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartid, @PathVariable Long productid) {
        Cart updatedCart = cartService.addProductToCart(cartid, productid);
        if (updatedCart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCart);
    }
    @PostMapping("/add/4/{productid}")
    public Cart addProductToCart(@PathVariable Long cartId, @RequestBody Product product) {
    	//cart 4
    	cartId=(long) 4;
        return cartService.addObjectProductToCart(cartId, product);
    }
    @PutMapping("/remove/{cartid}/{productid}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long cartid, @PathVariable Long productid) {
        Cart updatedCart = cartService.removeProductFromCart(cartid, productid);
        if (updatedCart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCart);
    }
    
    
    @PostMapping("/checkout/{cartId}")
    public ResponseEntity<?> checkoutCart(@PathVariable Long cartId) {
        Optional<Cart> cartOptional = cartService.getCartById(cartId);

        if (!cartOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
       Cart cart = cartOptional.get();
        if (cart.getStatus() != CartStatus.NEW) {
            return ResponseEntity.badRequest().body("gecersiz islem!");
        }

        if (cart.getCartProducts().isEmpty()) {
            return ResponseEntity.badRequest().body("sepet bos");
        }

        cart.setStatus(CartStatus.CHECKED_OUT);
        cartService.saveCart(cart);

       
        return ResponseEntity.ok("odeme basarili");
    }
    
    
    @PutMapping("/checkout")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart updatedCart) {
        Cart cart = cartService.updateCart(updatedCart);
        return ResponseEntity.ok(cart);
    }
}
