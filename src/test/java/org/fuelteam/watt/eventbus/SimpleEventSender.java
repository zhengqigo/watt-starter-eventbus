package org.fuelteam.watt.eventbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.EventBus;

@Component
public class SimpleEventSender {

    private final EventBus eventBus;

    @Autowired
    public SimpleEventSender(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void sendEvents() {
        this.eventBus.post(new SimpleEvent());
        this.eventBus.post(new NoOneSubscribedEvent());
    }
}
