package org.fuelteam.watt.eventbus;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.google.common.eventbus.AsyncEventBus;

@Component
public class SimpleAsyncEventSender {

    private final AsyncEventBus asyncEventBus;

    @Autowired
    public SimpleAsyncEventSender(final AsyncEventBus asyncEventSender) {
        this.asyncEventBus = asyncEventSender;
    }

    public void sendEvents() {
        this.asyncEventBus.post(new SimpleEvent());
    }
}
