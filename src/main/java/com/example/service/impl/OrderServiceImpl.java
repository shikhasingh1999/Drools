package com.example.service.impl;

import com.example.enums.RuleSet;
import com.example.model.Customer;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RuleEngineService ruleEngineService;

    @Override
    public Customer getOrderDiscount(Customer customer) {
        ruleEngineService.executeRules(RuleSet.CUSTOMER_CATEGORIZATION, customer);
        ruleEngineService.executeRules(RuleSet.DISCOUNT_CALCULATION, customer);
        return customer;
    }
}
