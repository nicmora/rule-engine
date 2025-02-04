package com.nicmora.ruleengine.application.usecase;

import com.nicmora.ruleengine.domain.messaging.subscriber.EvaluableSubscriber;
import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveEvaluable {

    private final EvaluableSubscriber evaluableSubscriber;

    public Evaluable retrieveEvaluable() {
        return evaluableSubscriber.retrieve();
    }

}
