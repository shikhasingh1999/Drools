package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum RuleSet {

    CUSTOMER_CATEGORIZATION("CustomerCategorizationSession"),
    CUSTOMER_TYPE("CustomerTypeSession"),
    DISCOUNT_CALCULATION("DiscountRulesSession");

    private final String folder;
}
