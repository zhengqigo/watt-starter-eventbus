package org.fuelteam.watt.eventbus;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = ExampleApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleAppIT {

    @Autowired
    private MultiEventBusSender multiEventBusSender;

    @Autowired
    private SimpleEventSender simpleEventSender;

    @Autowired
    private EventBusSupportSender eventBusSupportSender;

    @Autowired
    private SimpleAsyncEventSender simpleAsyncEventSender;

    @Autowired
    private SimpleSubscriber subscriber;

    @Autowired
    private LoggingDeadEventListener deadEventListener;

    @Test
    public void testEventBus() throws InterruptedException {
        this.multiEventBusSender.sendEvents();
        this.simpleEventSender.sendEvents();
        this.simpleAsyncEventSender.sendEvents();
        this.eventBusSupportSender.sendEvents();
        subscriber.getLatch().await(10, TimeUnit.SECONDS);
        deadEventListener.getLatch().await(5, TimeUnit.SECONDS);
    }
}
