package com.nicmora.ruleengine.infrastructure.messaging.subscriber;

import com.nicmora.ruleengine.application.messaging.subscriber.EvaluableSubscriber;
import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;
import com.nicmora.ruleengine.domain.model.evaluable.EvaluableExample;
import org.springframework.stereotype.Component;

@Component
public class EvaluablePubsubSubscriber implements EvaluableSubscriber {

    @Override
    public Evaluable retrieve() {
        // TODO: Listen to Pub/Sub
        return EvaluableExample.builder()
                .fieldA("A")
                .fieldB("B")
                .fieldC("C")
                .build();
    }

}
