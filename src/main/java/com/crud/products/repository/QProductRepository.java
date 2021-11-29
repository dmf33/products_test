package com.crud.products.repository;

import com.crud.products.domain.Product;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.crud.products.domain.QProduct.product;

@Component
public class QProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Product getProductById(Long productId) {
        var where = new BooleanBuilder().and(product.id.eq(productId));
        return new JPAQuery<>(entityManager).select(product).from(product).where(where).fetchOne();
    }

}