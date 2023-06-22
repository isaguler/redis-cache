package com.isaguler.rediscache.model;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    private Long id;

    private String cName;

    private boolean vip;
}
