package com.nicmora.ruleengine.domain.service;

import com.nicmora.ruleengine.domain.model.Condition;
import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class Evaluator {

    public static Rule eval(Evaluable evaluable, Set<Rule> rules) {
        return rules.stream()
                .sorted(Comparator.comparing(Rule::getPriority))
                .filter(rule -> evalRule(evaluable, rule))
                .findFirst()
                .orElse(null);
    }

    private static boolean evalRule(Evaluable evaluable, Rule rule) {
        return rule.getConditions()
                .stream()
                .allMatch(condition -> evalCondition(evaluable, condition));
    }

    private static boolean evalCondition(Evaluable evaluable, Condition condition) {
        String fieldName = condition.getFieldName();
        String operator = condition.getOperator();
        String operatorValue = condition.getOperatorValue();
        Map<String, String> fields = evaluable.getFields();

        String actualValue = fields.get(fieldName);

        if (actualValue == null) {
            return false;
        }

        return switch (operator) {
            case "==" -> actualValue.equals(operatorValue);
            case "!=" -> !actualValue.equals(operatorValue);
            case ">" -> compareNumbers(actualValue, operatorValue) > 0;
            case "<" -> compareNumbers(actualValue, operatorValue) < 0;
            case ">=" -> compareNumbers(actualValue, operatorValue) >= 0;
            case "<=" -> compareNumbers(actualValue, operatorValue) <= 0;
            default -> false;
        };
    }

    private static int compareNumbers(String actual, String expected) {
        try {
            double actualNum = Double.parseDouble(actual);
            double expectedNum = Double.parseDouble(expected);
            return Double.compare(actualNum, expectedNum);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
