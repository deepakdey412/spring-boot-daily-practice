package com.springSecurityPractice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product") // Base path for all product APIs
public class ProductController {

    // In-memory product list (no database yet)
    private List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1, "iPad", 4.5),
                    new Product(2, "iPhone", 7.5),
                    new Product(3, "MacBook", 12.0),
                    new Product(4, "Apple Watch", 3.5)
            )
    );

    // Simple record class for Product (acts as model)
    private record Product(Integer productId, String productName, double price) {}

    // GET: Returns all products
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    // POST: Adds a new product to the list
    // Requires valid CSRF token if CSRF protection is enabled
    @PostMapping
    public String addProduct(@RequestBody Product product) {
        products.add(product);
        return "Product added successfully!";
    }
}
