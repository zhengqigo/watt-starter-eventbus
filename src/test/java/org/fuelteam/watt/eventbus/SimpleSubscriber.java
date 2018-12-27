package org.fuelteam.watt.eventbus;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.Subscribe;

@Component
public class SimpleSubscriber {

    private CountDownLatch latch = new CountDownLatch(6);

    @Subscribe
    public void handle(final SimpleEvent event) {
        System.out.println("Handle Event " + JSON.toJSON(event));
        latch.countDown();
    }

    @Subscribe
    public void handle(final NoOneSubscribedEvent event) {
        System.out.println("Handle Event " + JSON.toJSON(event));
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return this.latch;
    }
}
