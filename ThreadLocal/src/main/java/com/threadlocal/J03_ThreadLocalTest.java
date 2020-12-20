package com.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ClassName: J03_ThreadLocalTest
 * Description: ThreadLocal用法
 * Date: 2020年12月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J03_ThreadLocalTest {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() +
                            " has put data: " + data);
                    threadLocal.set(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            int currentData = threadLocal.get();
            System.out.println("A from " + Thread.currentThread().getName() +
                    " get data: " + currentData);
        }
    }

    static class B {
        public void get() {
            int currentData = threadLocal.get();
            System.out.println("B from " + Thread.currentThread().getName() +
                    " get data: " + currentData);
        }
    }

}
