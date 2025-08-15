package com.example.service;

import com.example.model.OrderRequest;
import com.example.model.OrderResponse;

public interface OrderService {
    OrderRequest getOrderDiscount(OrderRequest orderRequest);
}
