package org.fuelteam.watt.eventbus;

import org.fuelteam.watt.eventbus.EventBusSupport;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class EventBusSupportSender {

    private final EventBusSupport eventBusSupport;

    @Autowired
    public EventBusSupportSender(final EventBusSupport eventBusSupport) {
        this.eventBusSupport = eventBusSupport;
    }

    public void sendEvents() {
        this.eventBusSupport.post(new SimpleEvent());
        this.eventBusSupport.postAsync(new SimpleEvent());
    }
}
