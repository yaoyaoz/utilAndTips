package proxy.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yaoyao on 2018/11/5.
 */
public class MapperProxy implements InvocationHandler {

    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //问题：不是说万物皆对象么，难道还有不是Object类的？
        if (Object.class.equals(method.getDeclaredAnnotations())) {
            try {
                //诸如hashCode(),toString(),equals()等方法，将target指向当前对象this
                return method.invoke(this, args);
            } catch (Throwable t) {
                System.out.println("异常：" + t.getMessage());
            }
        }
        //投鞭断流
        return new User((Integer) args[0], "zhangsan", 18);
    }
}
