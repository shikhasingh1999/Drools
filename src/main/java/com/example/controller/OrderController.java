package com.example.controller;

import com.example.model.Order;
import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/prepare")
    public ResponseEntity<OrderResponse> prepareOrder (@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.prepareOrder(request));
    }

    @PostMapping("/place")
    public ResponseEntity<OrderResponse> placeOrder (@RequestBody Order request) {
        return ResponseEntity.ok(orderService.placeOrder(request));
    }
}
