package ex.mybatis.domain;

import lombok.Getter;

@Getter
public class Product {

    private Long id;
    private String name;
    private Integer price;
    private Integer stockQuantity;

    public Product(String name, Integer price, Integer stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
