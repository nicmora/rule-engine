package com.nicmora.ruleengine.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rule {

    private Long id;
    private String description;
    private Integer priority;
    private Set<Condition> conditions;
    private String processType;
    private String result;
    private Boolean enabled;

}
