package com.nicmora.ruleengine.infrastructure.messaging.subscriber;

import com.nicmora.ruleengine.domain.messaging.subscriber.EvaluableSubscriber;
import com.nicmora.ruleengine.domain.model.evaluable.ProcessControl;
import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EvaluablePubsubSubscriber implements EvaluableSubscriber {

    @Override
    public Evaluable retrieve() {
        // TODO: Listen to Pub/Sub
        return ProcessControl.builder()
                .processType("CE")
                .fields(Map.of("fieldA", "A", "fieldB", "50", "fieldC", "10"))
                .build();
    }

}
