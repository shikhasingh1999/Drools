package com.example.service.impl;

import com.example.enums.RuleSet;
import com.example.model.Customer;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RuleEngineService {

    private final KieContainer kieContainer;

    public void executeRules(RuleSet ruleSet, Customer fact) {
        KieSession kieSession = kieContainer.newKieSession(ruleSet.getFolder());
            try {
                kieSession.insert(fact);
                kieSession.fireAllRules();
            } finally {
                kieSession.dispose();
            }
    }
}
