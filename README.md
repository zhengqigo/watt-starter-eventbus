# watt-starter-eventbus

```
<dependency>
  <groupId>org.fuelteam</groupId>
  <artifactId>watt-starter-eventbus</artifactId>
  <version>${version}</version>
</dependency>
```

Example for EventBus
```java
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
```
Example for AsyncEventBus and EventBus
```java
@Component
public class MultiEventBusSender {

    private final AsyncEventBus asyncEventBus;
    
    private final EventBus eventBus;
    
    @Autowired
    public MultiEventBusSender(final AsyncEventBus asyncEventBus, final EventBus eventBus) {
        this.asyncEventBus = asyncEventBus;
        this.eventBus = eventBus;
    }
    
    public void sendEvents() {
        this.asyncEventBus.post(new SimpleEvent());
        this.eventBus.post(new SimpleEvent());
    }
}
```
Example for EventBusSupport
```java
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
```
Example for event subscriber
```java
@Component
public class SimpleSubscriber {
    
    private final Logger logger = LoggerFactory.getLogger(SimpleSubscriber.class);
    
    @Subscribe
    public void handle(final SimpleEvent event) {
        logger.info("Handle Event : {}", event.toString());
    }

    @Subscribe
    public void handle(final OtherEvent event) {
        logger.info("Handle Event : {}", event.toString());
    }
}
```
