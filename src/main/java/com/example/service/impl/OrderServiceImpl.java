package com.example.service.impl;

import com.example.enums.RuleSet;
import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RuleEngineService ruleEngineService;

    @Override
    public OrderRequest getOrderDiscount(OrderRequest orderRequest) {
        ruleEngineService.executeRules(RuleSet.CUSTOMER_CATEGORIZATION, orderRequest);
//        ruleEngineService.executeRules(RuleSet.DISCOUNT_CALCULATION, orderRequest);
        return orderRequest;
    }
}
