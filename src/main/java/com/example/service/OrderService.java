package com.example.service;

import com.example.model.Customer;
import com.example.model.Order;
import com.example.model.OrderRequest;
import com.example.model.OrderResponse;

public interface OrderService {
    OrderResponse prepareOrder(OrderRequest orderRequest);

    OrderResponse placeOrder (Order order);


}
