package com.crud.products.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "product")
public class Product extends AbstractModel implements Serializable {

    private String name;

    private Double price;

}