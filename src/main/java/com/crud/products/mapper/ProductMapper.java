package com.crud.products.mapper;

import com.crud.products.domain.Product;
import com.crud.products.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    List<ProductDto> toDtos(List<Product> products);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Product fromDto(ProductDto productDto);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    void updateFromDto(ProductDto productDto, @MappingTarget Product entity);
}

