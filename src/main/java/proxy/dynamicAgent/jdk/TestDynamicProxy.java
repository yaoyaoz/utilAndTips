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

    @Test
    public void test() {
        math.add(1, 2);//问题：这里怎么调到proxy.dynamicAgent.jdk.DynamicProxy#invoke去的？
        math.sub(4, 6);
    }

}
