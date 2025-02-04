package com.nicmora.ruleengine.domain.model.evaluable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessControl implements Evaluable {

    private String processType;
    private Map<String, String> fields;

}
