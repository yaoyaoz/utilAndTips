package eventBus;

import com.google.common.eventbus.EventBus;

/**
 * EventBus是Google.Guava提供的消息发布-订阅类库，
 * 它实现了观察者设计模式，消息通知负责人通过EventBus去注册/注销观察者，
 * 最后由消息通知负责人给观察者发布消息。
 *
 * Created by yaoyao on 2018/12/5.
 */
public class EventBusCenter {

    private static EventBus eventBus = new EventBus();

    public EventBusCenter() {

    }

    public static EventBus getInstance() {
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }

}
