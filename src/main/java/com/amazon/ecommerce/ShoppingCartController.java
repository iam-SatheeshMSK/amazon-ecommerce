package com.amazon.ecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart") // Store cart in session
public class ShoppingCartController {

    // Initialize cart as a list of items
    @ModelAttribute("cart")
    public List<ShoppingCartItem> initializeCart() {
        return new ArrayList<>();
    }

    // View shopping cart
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", model.getAttribute("cart"));
        return "shopping-cart"; // Refers to shopping-cart.html
    }

    // Add item to cart
    @PostMapping("/cart/add")
    public String addToCart(@ModelAttribute("cart") List<ShoppingCartItem> cart,
                            @RequestParam String productId,
                            @RequestParam String productName,
                            @RequestParam double price) {
        // Check if item already exists in cart
        boolean itemExists = cart.stream()
                .anyMatch(item -> item.getProductId().equals(productId));

        if (itemExists) {
            // Update quantity
            cart.forEach(item -> {
                if (item.getProductId().equals(productId)) {
                    item.setQuantity(item.getQuantity() + 1);
                }
            });
        } else {
            // Add new item
            cart.add(new ShoppingCartItem(productId, productName, price, 1));
        }

        return "redirect:/cart"; // Redirect to cart page
    }

    // Remove item from cart
    @PostMapping("/cart/remove/{productId}")
    public String removeFromCart(@ModelAttribute("cart") List<ShoppingCartItem> cart,
                                 @PathVariable String productId) {
        cart.removeIf(item -> item.getProductId().equals(productId));
        return "redirect:/cart";
    }
}
