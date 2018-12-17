package eventBus;

import javax.xml.crypto.Data;

/**
 * eventBus测试类
 *
 * Created by yaoyao on 2018/12/17.
 */
public class TestEventBus {

    public static void main(String[] args) {
        DataObserver1 observer1 = new DataObserver1();
        DataObserver2 observer2 = new DataObserver2();

        EventBusCenter.register(observer1);
        EventBusCenter.register(observer2);

        System.out.println("===========   start   ===========");

        EventBusCenter.post(9);
        EventBusCenter.post("post string method");

        System.out.println("===========   after unregister   ===========");
        EventBusCenter.unregister(observer2);
        EventBusCenter.post(9);
        EventBusCenter.post("post string method");

        System.out.println("===========    end    ===========");
    }

}
