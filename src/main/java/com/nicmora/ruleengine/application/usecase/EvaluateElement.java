package com.nicmora.ruleengine.application.usecase;

import com.nicmora.ruleengine.domain.model.Result;
import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;
import com.nicmora.ruleengine.domain.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EvaluateElement {

    private final RuleRepository ruleRepository;

    public Result evaluateElementWithRules(Evaluable evaluable) {
        String ruleType = evaluable.getRuleType();
        Set<Rule> rules = new HashSet<>(ruleRepository.findByRuleType(ruleType));

        Rule rule = evaluable.evaluate(rules);

        return rule.getResult();
    }

}
