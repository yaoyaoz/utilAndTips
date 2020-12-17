package com.threadlocal;

import java.util.Random;

/**
 * ClassName: J01_ThreadScopeShareData
 * Description: 两个线程get到的data数据不是独立的
 * Date: 2020年12月17日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J01_ThreadScopeShareData {

    private static int data = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() +
                            " has put data: " + data);

                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            System.out.println("A from " + Thread.currentThread().getName() +
                    " get data: " + data);
        }
    }

    static class B {
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName() +
                    " get data: " + data);
        }
    }

}
