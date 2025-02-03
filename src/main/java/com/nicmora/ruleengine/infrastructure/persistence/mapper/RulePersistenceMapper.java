package com.nicmora.ruleengine.infrastructure.persistence.mapper;

import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.infrastructure.persistence.entity.RuleEntity;
import org.springframework.stereotype.Component;

@Component
//@Mapper
public class RulePersistenceMapper {

//    private RulePersistenceMapper INSTANCE = Mappers.getMapper(RulePersistenceMapper.class);

//    @Mapping
//    Rule toModel(RuleEntity rule) {
//        return new Rule();
//    };

    public Rule toModel(RuleEntity ruleEntity) {
        return new Rule();
    }

    public RuleEntity toEntity(Rule rule) {
        return new RuleEntity();
    }

}
