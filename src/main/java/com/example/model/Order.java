package com.example.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private String orderId;
    private Customer customer;
    private BigDecimal amount;
    private Double discountApplied;
    private BigDecimal finalAmount;

}
