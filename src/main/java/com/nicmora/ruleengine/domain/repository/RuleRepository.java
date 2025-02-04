package com.nicmora.ruleengine.domain.repository;

import com.nicmora.ruleengine.domain.model.Rule;

import java.util.List;

public interface RuleRepository {

    List<Rule> findAll();
    List<Rule> findByProcessType(String processType);

}
