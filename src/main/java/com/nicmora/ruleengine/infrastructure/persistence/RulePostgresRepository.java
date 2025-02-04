package com.nicmora.ruleengine.infrastructure.persistence;

import com.nicmora.ruleengine.domain.model.Rule;
import com.nicmora.ruleengine.domain.repository.RuleRepository;
import com.nicmora.ruleengine.infrastructure.persistence.jpa.RuleJpaRepository;
import com.nicmora.ruleengine.infrastructure.persistence.mapper.RulePersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RulePostgresRepository implements RuleRepository {

    private final RuleJpaRepository ruleJpaRepository;
    private final RulePersistenceMapper rulePersistenceMapper;

    @Override
    public List<Rule> findAll() {
        return ruleJpaRepository.findAll()
                .stream()
                .map(rulePersistenceMapper::toModel)
                .toList();
    }

    @Override
    public List<Rule> findByProcessType(String processType) {
        return ruleJpaRepository.findByRuleType(processType)
                .stream()
                .map(rulePersistenceMapper::toModel)
                .toList();
    }

}
