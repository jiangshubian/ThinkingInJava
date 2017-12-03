package com.shu.twentyfirstchapter.concurrency.shareResource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-12-03 22:47
 * @Version: 1.0.0
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }


    public void timed() {
        boolean captured = false;

        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);//blocking wait timeout or was interrupted
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2,TimeUnit.SECONDS):" + captured);
        } finally {
            if (captured) lock.unlock();
        }
    }


    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();

        //Create a separate task to grab the lock.
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired...");
            }
        }.start();

        Thread.yield();
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.untimed();
        al.timed();
    }
}
