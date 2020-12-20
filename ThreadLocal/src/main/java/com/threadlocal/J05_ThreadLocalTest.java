package com.threadlocal;

import java.util.Random;

/**
 * ClassName: J05_ThreadLocalTest
 * Description: ThreadLocal存对象（优雅的写法）
 * Date: 2020年12月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J05_ThreadLocalTest {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() +
                            " has put data: " + data);
                    MyThreadScopeData2.getThreadInstance().setName("name" + data);
                    MyThreadScopeData2.getThreadInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            MyThreadScopeData2 myData = MyThreadScopeData2.getThreadInstance();
            System.out.println("A from " + Thread.currentThread().getName() +
                    " getMyData: " + myData.getName() + "," + myData.getAge());
        }
    }

    static class B {
        public void get() {
            MyThreadScopeData2 myData = MyThreadScopeData2.getThreadInstance();
            System.out.println("B from " + Thread.currentThread().getName() +
                    " getMyData: " + myData.getName() + "," + myData.getAge());
        }
    }

}

class MyThreadScopeData2 {

    private static ThreadLocal<MyThreadScopeData2> map = new ThreadLocal<>();

    private MyThreadScopeData2() {
    }

    public static MyThreadScopeData2 getThreadInstance() {
        MyThreadScopeData2 instance = map.get();
        if (instance == null) {
            instance = new MyThreadScopeData2();
            map.set(instance);
        }
        return instance;
    }

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
