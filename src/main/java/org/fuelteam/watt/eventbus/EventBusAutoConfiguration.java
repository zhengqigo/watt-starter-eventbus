package org.fuelteam.watt.eventbus;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

@Configuration
public class EventBusAutoConfiguration {

    @Bean
    public EventBusSupport eventBusWrapper() {
        return new EventBusSupportImpl(eventBus(), asyncEventBus());
    }

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

    @Bean
    public AsyncEventBus asyncEventBus() {
        Integer cores = Runtime.getRuntime().availableProcessors() + 1;
        return new AsyncEventBus("asyncEventBus", Executors.newFixedThreadPool(cores));
    }

    @Bean
    public EventBusSubscriberBeanPostProcessor subscriberAnnotationProcessor() {
        return new EventBusSubscriberBeanPostProcessor(eventBus(), asyncEventBus());
    }

    public static final class EventBusSupportImpl implements EventBusSupport {

        private EventBus eventBus;

        private AsyncEventBus asyncEventBus;

        public EventBusSupportImpl(final EventBus eventBus, final AsyncEventBus asyncEventBus) {
            this.eventBus = eventBus;
            this.asyncEventBus = asyncEventBus;
        }

        public void post(final Object event) {
            this.eventBus.post(event);
        }

        public void postAsync(final Object event) {
            this.asyncEventBus.post(event);
        }
    }
}
