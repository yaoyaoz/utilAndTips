package proxy.staticAgent;

import org.junit.Test;

/**
 * 测试静态代理
 *
 * Created by yaoyao on 2018/11/1.
 */
public class TestStaticAgent {

    IMath math = new Math();
    IMath mathProxy = new MathProxy();

    @Test
    public void test() {
        mathProxy.add(1,3);
        mathProxy.sub(3,5);
    }

}
