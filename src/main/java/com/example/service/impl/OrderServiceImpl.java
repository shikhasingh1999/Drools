package com.example.service.impl;

import com.example.enums.RuleSet;
import com.example.model.Customer;
import com.example.model.Order;
import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RuleEngineService ruleEngineService;

    @Override
    public OrderResponse prepareOrder(OrderRequest request) {
        Customer customer = buildCustomerRequest(request);

        // Apply Customer Rules to identify type
        ruleEngineService.executeRules(RuleSet.CUSTOMER_TYPE, customer);

        // Apply Customer Rules to identify category
        ruleEngineService.executeRules(RuleSet.CUSTOMER_CATEGORIZATION, customer);

        // Apply Discount Rules to the order based on Customer Rules output
        ruleEngineService.executeRules(RuleSet.DISCOUNT_CALCULATION, customer);

        Order order = buildOrder (customer, request.getAmount());

        return new OrderResponse(order, "Discount Applied, confirm order?", false);
    }

    private Customer buildCustomerRequest(OrderRequest request) {
        Customer customer = new Customer();
        customer.setCustomerName(request.getCustomerName());
        customer.setOrdersCount(request.getOrdersCount());
        customer.setTotalSpent(request.getTotalSpent());
        customer.setCardType(request.getCardType());
        return customer;
    }

    private Order buildOrder (Customer customer, BigDecimal amount) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setAmount(amount);
        order.setDiscountApplied(customer.getDiscountPercentage());
        BigDecimal discountPercentage = BigDecimal.valueOf(customer.getDiscountPercentage()); // double → BigDecimal
        BigDecimal discountFraction = discountPercentage.divide(BigDecimal.valueOf(100)); // convert to fraction
        BigDecimal finalAmount = amount.multiply(BigDecimal.ONE.subtract(discountFraction)); // amount * (1 - discountFraction)
        order.setFinalAmount(finalAmount);
        return order;
    }

    @Override
    public OrderResponse placeOrder (Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        return new OrderResponse(order, "Order Placed", true);
    }
}
