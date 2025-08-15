package com.example.model;

import com.example.enums.CardType;
import com.example.enums.CustomerCategory;
import com.example.enums.CustomerType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Customer {

    private String customerName;
    private int ordersCount;
    private CardType cardType;
    private BigDecimal totalSpent;

    // set by Drools
    private CustomerType type;
    private CustomerCategory category;
    private double discountPercentage;








}
