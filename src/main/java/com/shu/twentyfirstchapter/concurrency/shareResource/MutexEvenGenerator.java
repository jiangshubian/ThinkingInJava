package com.shu.twentyfirstchapter.concurrency.shareResource;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-12-03 22:30
 * @Version: 1.0.0
 */
public class MutexEvenGenerator extends IntGenerator {
    private volatile int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            Condition condition = lock.newCondition();
            System.out.println(condition);
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
