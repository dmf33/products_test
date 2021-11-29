package com.crud.products.service;

import com.crud.products.dto.ProductDto;
import com.crud.products.manager.ProductManager;
import com.crud.products.mapper.ProductMapper;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductManager productManager;

    public ProductDto createProduct(ProductDto productDto) {
        var product = productManager.createProduct(productMapper.fromDto(productDto));
        log.info(String.format("Product ID = %d created", product.getId()));
        return productMapper.toDto(product);
    }

    public ProductDto getProductById(@NonNull Long productId) {
        return productMapper.toDto(productManager.getProductById(productId));
    }

    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        var product = productManager.getProductById(productId);
        productMapper.updateFromDto(productDto, product);
        return productMapper.toDto(productManager.updateProduct(product));
    }

    public void deleteProduct(@NonNull Long productId) {
        log.info("Product ID = {} deletion", productId);
        productManager.deleteProduct(productId);
        log.info("Product ID = {} deleted", productId);
    }
}