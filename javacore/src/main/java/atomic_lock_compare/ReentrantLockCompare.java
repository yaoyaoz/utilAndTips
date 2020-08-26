package atomic_lock_compare;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: ReentrantLockCompare
 * Description:
 * Date: 2020年08月26日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class ReentrantLockCompare {

    private static ReentrantLock lock = new ReentrantLock();

    private static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                add();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                add();
            }
        });
        t2.start();

        t1.join();
        t2.join();

        log.info("count:[{}]", count);
        log.info("ReentrantLock加到20000000耗时:[{}]", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

}
