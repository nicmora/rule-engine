package com.nicmora.ruleengine.domain.model.evaluable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluableExample implements Evaluable {

    private String fieldA;
    private String fieldB;
    private String fieldC;

    private String ruleType;

    @Override
    public String getRuleType() {
        return ruleType;
    }

}
