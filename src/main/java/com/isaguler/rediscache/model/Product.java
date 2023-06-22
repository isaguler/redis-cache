package com.isaguler.rediscache.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    private Long id;

    private String pName;

    private BigDecimal price;
}
