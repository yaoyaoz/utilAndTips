package proxy.dynamicAgent.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理：
 * 使用JDK内置的Proxy实现
 * <p>
 * Created by yaoyao on 2018/11/2.
 */
public class DynamicProxy implements InvocationHandler {

    //被代理的对象
    Object targetObject;

    //获得被代理的对象
    public Object getProxyObject(Object object) {
        this.targetObject = object;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //被织入的内容，开始时间
        long start = System.currentTimeMillis();

        //使用反射在目标对象上调用方法并传入参数
        Object result = method.invoke(targetObject, args);

        //被织入的内容，结束时间
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);

        return result;
    }

}
