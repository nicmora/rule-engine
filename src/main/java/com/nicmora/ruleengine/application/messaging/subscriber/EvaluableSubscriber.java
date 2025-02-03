package com.nicmora.ruleengine.application.messaging.subscriber;

import com.nicmora.ruleengine.domain.model.evaluable.Evaluable;

public interface EvaluableSubscriber {

    Evaluable retrieve();

}
