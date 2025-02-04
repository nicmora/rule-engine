package com.nicmora.ruleengine.domain.model.evaluable;

import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.domain.service.Evaluator;

import java.util.Map;
import java.util.Set;

public interface Evaluable {

    String getProcessType();
    Map<String, String> getFields();

    default Rule evaluate(Set<Rule> rules) {
        return Evaluator.eval(this, rules);
    }

}
