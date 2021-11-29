package com.crud.products.controller;

import com.crud.products.dto.ProductDto;
import com.crud.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/create")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("/{productId}")
    public ProductDto updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productId, productDto);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}
