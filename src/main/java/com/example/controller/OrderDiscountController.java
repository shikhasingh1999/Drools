package com.example.controller;

import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order/discount")
@RequiredArgsConstructor
public class OrderDiscountController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<OrderRequest> getOrderDiscount(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.getOrderDiscount(orderRequest));
    }
}
