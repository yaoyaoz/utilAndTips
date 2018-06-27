package thread;

import org.junit.Test;

/**
 * Created by yaoyao on 2018/6/22.
 */
public class TestThread {

    @Test
    public void testThread() {
        System.out.println("lalala-a");
        System.out.println("lalala-b");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.println("Thread1:" + i);
                }
            }
        }).start();
        System.out.println("lalala-c");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.println("Thread2--:" + i);
                }
            }
        }).start();
        System.out.println("lalala-d");
        System.out.println("lalala-e");
    }

}
