package org.fuelteam.watt.eventbus;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

// This listener brings dead events (events where no listener was found) to the console
@Component
public class LoggingDeadEventListener {

    private CountDownLatch latch = new CountDownLatch(1);

    @Subscribe
    public void handleDeadEvent(final DeadEvent deadEvent) {
        System.out.println("Ooops, no listener found for event " + deadEvent.getEvent());
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
