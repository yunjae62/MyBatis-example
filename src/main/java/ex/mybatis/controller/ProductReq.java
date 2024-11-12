package ex.mybatis.controller;

import ex.mybatis.domain.Product;

public record ProductReq(
    String name,
    Integer price,
    Integer stockQuantity
) {

    Product toEntity() {
        return new Product(name, price, stockQuantity);
    }
}
