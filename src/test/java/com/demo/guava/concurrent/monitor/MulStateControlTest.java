package com.demo.guava.concurrent.monitor;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liliang on 2017/7/14.
 */
public class MulStateControlTest
{
    private ReentrantReadWriteLock locker = new ReentrantReadWriteLock();

    @Test
    public void testBase() {
        ComStatus initStatus = new ComStatus();
        initStatus.setState1(0);
        initStatus.setState2(0);
        CombinationStatTask task = new CombinationStatTask(initStatus,locker);
        Thread thread = new Thread(task);
        thread.start();

        Random random = new Random();
        while (true) {
            locker.writeLock().lock();
            try {
                int rand = random.nextInt(1000);
                initStatus.setState1(rand);
                initStatus.setState2(rand * 2);
            } finally {
                locker.writeLock().unlock();
            }
        }
    }

    private static class CombinationStatTask implements Runnable {
        // 对于组合状态，加 volatile 不能解决问题
        private ComStatus comStatus;

        private ReentrantReadWriteLock locker;

        public CombinationStatTask(ComStatus comStatus, ReentrantReadWriteLock locker) {
            this.comStatus = comStatus;
            this.locker = locker;
        }

        @Override
        public void run() {
            int c = 0;
            for (long i = 0; ; i++) {
                int i1 = 1;
                int i2 = -1;
                locker.readLock().lock();
                try {
                    i1 = comStatus.getState1();
                    i2 = comStatus.getState2();
                } finally {
                    locker.readLock().unlock();
                }
                if (i1 * 2 != i2) {
                    c++;
                    System.err.printf("Fuck! Got invalid CombinationStat!! check time=%s, happen time=%s(%s%%), count value=%s|%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, i1, i2);
                } else {
                    // 如果去掉这个输出，则在我的开发机上，发生无效组合的概率由 ~5% 降到 ~0.1%
                    System.out.printf("Emm... %s|%s\n", i1, i2);
                }
            }
        }
    }
}
