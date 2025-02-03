package com.nicmora.ruleengine.application.usecase;

import com.nicmora.ruleengine.domain.model.Condition;
import com.nicmora.ruleengine.domain.model.Result;
import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;
import com.nicmora.ruleengine.domain.model.evaluable.EvaluableExample;
import com.nicmora.ruleengine.domain.repository.RuleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EvaluateElementTest {

    @Mock
    RuleRepository ruleRepository;

    @InjectMocks
    EvaluateElement evaluateElement;

    Evaluable evaluable;
    List<Rule> rules;

    @BeforeEach
    void setUp() {
        evaluable = getEvaluableExample();
        rules = List.of(getRuleOne(), getRuleTwo());
    }

    @Test
    void evaluateElementWithRules() {
        // Arrange
        when(ruleRepository.findByRuleType(evaluable.getRuleType())).thenReturn(rules);

        // Act
        Result result = evaluateElement.evaluateElementWithRules(evaluable);

        // Assert
        assertEquals("OK", result.getStatus());
        assertEquals("Rule 1 OK", result.getMessage());
    }

    Evaluable getEvaluableExample() {
        return EvaluableExample.builder()
                .fieldA("A")
                .fieldB("50")
                .fieldC("10")
                .ruleType("CE")
                .build();
    }

    Rule getRuleOne() {
        return Rule.builder()
                .id(1L)
                .ruleType("CE")
                .description("Rule 1")
                .priority(0)
                .conditions(Set.of(getConditionOne(), getConditionTwo(), getConditionThree()))
                .result(getResultOne())
                .enabled(true)
                .build();
    }

    Rule getRuleTwo() {
        return Rule.builder()
                .id(1L)
                .ruleType("CE")
                .description("Rule 2")
                .priority(0)
                .conditions(Set.of(getConditionFour()))
                .result(getResultTwo())
                .enabled(true)
                .build();
    }

    Result getResultOne() {
        return Result.builder()
                .status("OK")
                .message("Rule 1 OK")
                .build();
    }

    Result getResultTwo() {
        return Result.builder()
                .status("NOK")
                .message("Rule 2 NOK")
                .build();
    }

    Condition getConditionOne() {
        return Condition.builder()
                .fieldName("fieldA")
                .operator("==")
                .operatorValue("A")
                .build();
    }

    Condition getConditionTwo() {
        return Condition.builder()
                .fieldName("fieldB")
                .operator(">")
                .operatorValue("10")
                .build();
    }

    Condition getConditionThree() {
        return Condition.builder()
                .fieldName("fieldC")
                .operator("<")
                .operatorValue("100")
                .build();
    }

    Condition getConditionFour() {
        return Condition.builder()
                .fieldName("fieldA")
                .operator("==")
                .operatorValue("Z")
                .build();
    }

}