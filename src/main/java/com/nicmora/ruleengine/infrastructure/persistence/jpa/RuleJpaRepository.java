package com.nicmora.ruleengine.infrastructure.persistence.jpa;

import com.nicmora.ruleengine.infrastructure.persistence.entity.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleJpaRepository extends JpaRepository<RuleEntity, Long> {

    List<RuleEntity> findByRuleType(String ruleType);

}
