package proxy.dynamicAgent.jdk;

import org.junit.Test;
import proxy.staticAgent.IMath;
import proxy.staticAgent.Math;

/**
 * 动态代理测试类：
 * 使用JDK内置的Proxy实现
 * <p>
 * Created by yaoyao on 2018/11/2.
 */
public class TestDynamicProxy {

    /**
     * 实例化一个MathProxy代理对象
     * 通过getProxyObject方法获得被代理后的对象
     */
    IMath math = (IMath) new DynamicProxy().getProxyObject(new Math());

    Message message = (Message) new DynamicProxy().getProxyObject(new Message());

    @Test
    public void test1() {
        math.add(1, 2);//问题：这里怎么调到proxy.dynamicAgent.jdk.DynamicProxy#invoke去的？
        math.sub(4, 6);
    }

    /**
     * 这个单元测试会报错：
     * 因为使用内置的Proxy实现动态代理有一个问题：
     * 被代理的类必须实现接口，未实现接口则没办法完成动态代理
     */
    @Test
    public void test2() {
        message.send();
    }

}
