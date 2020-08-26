package atomic_lock_compare;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: AtomicIntegerCompare
 * Description: 原子类
 * Date: 2020年08月26日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
/*
比较ReentrantLock和AtomicInteger累加数字的性能。
观察运行结果，得出结论：原子类AtomicInteger效率要高与lock
 */
@Slf4j
public class AtomicIntegerCompare {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                atomicInteger.incrementAndGet();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                atomicInteger.incrementAndGet();
            }
        });
        t2.start();

        t1.join();
        t2.join();

        log.info("count:[{}]", atomicInteger);
        log.info("AtomicInteger加到20000000耗时:[{}]", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

}
