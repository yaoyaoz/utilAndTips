package com.threadlocal;

import java.util.Random;

/**
 * ClassName: J04_ThreadLocalTest
 * Description: ThreadLocal存对象（不太优雅的写法）
 * Date: 2020年12月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J04_ThreadLocalTest {

    static ThreadLocal<MyThreadScopeData1> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() +
                            " has put data: " + data);
                    MyThreadScopeData1 myData = new MyThreadScopeData1();
                    myData.setName("name" + data);
                    myData.setAge(data);
                    threadLocal.set(myData);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            MyThreadScopeData1 myData = threadLocal.get();
            System.out.println("A from " + Thread.currentThread().getName() +
                    " getMyData: " + myData.getName() + "," + myData.getAge());
        }
    }

    static class B {
        public void get() {
            MyThreadScopeData1 myData = threadLocal.get();
            System.out.println("B from " + Thread.currentThread().getName() +
                    " getMyData: " + myData.getName() + "," + myData.getAge());
        }
    }

}

class MyThreadScopeData1 {
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
