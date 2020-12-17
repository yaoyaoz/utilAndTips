package com.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ClassName: J01_ThreadScopeShareData
 * Description: 两个线程get到的data数据是隔离开的
 * Date: 2020年12月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J02_ThreadScopeShareData {

    private static int data = 0;

    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() +
                            " has put data: " + data);
                    threadData.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            int currentData = threadData.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName() +
                    " get data: " + currentData);
        }
    }

    static class B {
        public void get() {
            int currentData = threadData.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName() +
                    " get data: " + currentData);
        }
    }

}
