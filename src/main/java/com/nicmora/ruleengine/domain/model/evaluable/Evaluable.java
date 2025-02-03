package com.nicmora.ruleengine.domain.model.evaluable;

import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.domain.service.Evaluator;

import java.lang.reflect.Field;
import java.util.Set;

public interface Evaluable {

    String getRuleType();

    default Rule evaluate(Set<Rule> rules) {
        return Evaluator.evaluate(this, rules);
    }

    default String getAttributeValue(String attributeName) {
        try {
            Field field = this.getClass().getDeclaredField(attributeName);
            field.setAccessible(true);
            return (String) field.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
