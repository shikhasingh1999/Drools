package com.example.model;

import com.example.enums.CardType;
import com.example.enums.CustomerCategory;
import com.example.enums.CustomerType;
import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderRequest {

    private String customerName;
    private Integer age;
    private BigInteger amount;
    private BigInteger totalSpent;
    private CustomerType customerType;
    private CustomerCategory customerCategory;
    private CardType cardType;
}
