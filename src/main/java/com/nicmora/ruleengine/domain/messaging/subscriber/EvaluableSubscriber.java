package com.nicmora.ruleengine.domain.messaging.subscriber;

import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;

public interface EvaluableSubscriber {

    Evaluable retrieve();

}
