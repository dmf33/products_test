package com.crud.products.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @CreationTimestamp
    @Column(name = "added", updatable = false)
    private Date added;

    @UpdateTimestamp
    private Date changed;
}