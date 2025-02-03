package com.nicmora.ruleengine.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleEntity {

    @Id
    private Long id;
    private String description;
    private Integer priority;
    private String conditions; // TODO: jsonb
    private String ruleType;
    private String resultStatus;
    private String resultMessage;
    private Boolean enabled;

}
