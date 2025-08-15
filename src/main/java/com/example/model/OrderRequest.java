package com.example.model;

import com.example.enums.CardType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {

    private String customerName;
    private int ordersCount;
    private CardType cardType;
    private BigDecimal totalSpent;
    private BigDecimal amount;
}
