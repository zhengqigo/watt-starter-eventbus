package org.fuelteam.watt.eventbus;

// To let the {@link LoggingDeadEventListener} do something logout on console
public class NoOneSubscribedEvent {
    
    private String event = "NoOneSubscribed";

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
