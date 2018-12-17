package eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * 观察者二
 *
 * Created by yaoyao on 2018/12/17.
 */
public class DataObserver2 {

    /**
     * post() 不支持自动装箱功能,只能使用Integer,不能使用int,否则handlersByType的Class会是int而不是Integer
     * 而传入的int msg参数在post(int msg)的时候会被包装成Integer,导致无法匹配到
     *
     * @param msg
     */
    @Subscribe
    public void func(Integer msg) {
        System.out.println("int msg: " + msg);
    }

}
