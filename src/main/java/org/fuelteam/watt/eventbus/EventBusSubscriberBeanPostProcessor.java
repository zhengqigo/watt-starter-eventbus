package org.fuelteam.watt.eventbus;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusSubscriberBeanPostProcessor implements BeanPostProcessor {

    private EventBus eventBus;

    private AsyncEventBus asyncEventBus;

    @Autowired
    public EventBusSubscriberBeanPostProcessor(final EventBus eventBus, final AsyncEventBus asyncEventBus) {
        this.eventBus = eventBus;
        this.asyncEventBus = asyncEventBus;
    }

    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        for (Method method : bean.getClass().getMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                this.eventBus.register(bean);
                this.asyncEventBus.register(bean);
                break;
            }
        }
        return bean;
    }
}
