package com.nicmora.ruleengine.application.usecase;

import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;
import com.nicmora.ruleengine.domain.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EvaluateElement {

    private final RuleRepository ruleRepository;

    public String evaluateElementWithRules(Evaluable evaluable) {
        String processType = evaluable.getProcessType();
        Set<Rule> rules = new HashSet<>(ruleRepository.findByProcessType(processType));

        return Optional.ofNullable(evaluable.evaluate(rules))
                .map(Rule::getResult)
                .orElse("Unknown");
    }

}
