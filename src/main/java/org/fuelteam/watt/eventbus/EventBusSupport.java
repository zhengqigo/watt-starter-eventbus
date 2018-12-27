package org.fuelteam.watt.eventbus;

public interface EventBusSupport {

    void post(Object event);

    void postAsync(Object event);
}
