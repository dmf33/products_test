package com.crud.products.manager;

import com.crud.products.domain.Product;
import com.crud.products.exception.NotFoundException;
import com.crud.products.repository.ProductRepository;
import com.crud.products.repository.QProductRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ProductManager {

    @Autowired
    private QProductRepository qProductRepository;

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        product = productRepository.save(product);
        return product;
    }

    @Transactional(readOnly = true)
    public Product getProductById(@NonNull Long productId) {
        Product product = qProductRepository.getProductById(productId);
        if (product == null) {
            log.info(String.format("Product=%s is not found.", productId));
            throw new NotFoundException(String.format("Product=%s is not found.", productId));
        }
        return product;
    }

    @Transactional
    public Product updateProduct(Product product) {
        log.info("Product ID = {} updating", product.getId());
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        // check exists
        this.getProductById(productId);
        productRepository.deleteById(productId);
    }
}