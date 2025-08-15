package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RuleSet {

    CUSTOMER_CATEGORIZATION("CustomerCategorizationSession"),
    CUSTOMER_TYPE("CustomerTypeSession"),
    DISCOUNT_CALCULATION("DiscountRulesSession");

    private final String folder;
}
