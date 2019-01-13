package java_.keywords.synchronize;

/**
 * 消失的请求数：
 * t1和t2线程分别执行100000，最终输出i应该是200000，但实际输出小于200000。
 * 因为count++看上去是一个动作，实际上包含了三个动作：
 * 1、读取count
 * 2、将count加一
 * 3、将count的值写入到内存中
 *
 * Created by yaoyao on 2019-01-12.
 */
public class DisappearRequest1 implements Runnable {

    static DisappearRequest1 instance = new DisappearRequest1();

    static int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        try {
            //等t1、t2线程执行完毕再执行后面的代码
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
