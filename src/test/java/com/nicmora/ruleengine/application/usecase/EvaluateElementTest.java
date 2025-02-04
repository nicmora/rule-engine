package com.nicmora.ruleengine.application.usecase;

import com.nicmora.ruleengine.domain.model.Condition;
import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.domain.model.evaluable.ProcessControl;
import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;
import com.nicmora.ruleengine.domain.repository.RuleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        when(ruleRepository.findByProcessType(evaluable.getProcessType())).thenReturn(rules);

        // Act
        String result = evaluateElement.evaluateElementWithRules(evaluable);

        // Assert
        assertEquals("OK", result);
    }

    Evaluable getEvaluableExample() {
        return ProcessControl.builder()
                .processType("CE")
                .fields(Map.of("fieldA", "A", "fieldB", "50", "fieldC", "10"))
                .build();
    }

    Rule getRuleOne() {
        return Rule.builder()
                .id(1L)
                .processType("CE")
                .description("Rule 1")
                .priority(0)
                .conditions(Set.of(getConditionOne(), getConditionTwo(), getConditionThree()))
                .result("OK")
                .enabled(true)
                .build();
    }

    Rule getRuleTwo() {
        return Rule.builder()
                .id(1L)
                .processType("CE")
                .description("Rule 2")
                .priority(1)
                .conditions(Set.of(getConditionFour()))
                .result("NOK")
                .enabled(true)
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