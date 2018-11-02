package proxy.dynamicAgent.cglib;

import org.junit.Test;
import proxy.dynamicAgent.jdk.Message;
import proxy.staticAgent.IMath;
import proxy.staticAgent.Math;

/**
 * 动态代理测试类：
 * 实现了一个方法拦截器接口
 * <p>
 * Created by yaoyao on 2018/11/2.
 */
public class TestDynamicProxy {

    IMath math = (IMath) new DynamicProxy().getProxyObject(new Math());

    @Test
    public void test1() {
        math.add(1, 2);//问题：怎么调到proxy.dynamicAgent.cglib.DynamicProxy.intercept()方法的？
        math.sub(3, 1);
    }

    //另一个被代理的对象,不再需要重新编辑代理代码
    Message message = (Message) new DynamicProxy().getProxyObject(new Message());
    @Test
    public void test2() {
        message.send();
    }

}
