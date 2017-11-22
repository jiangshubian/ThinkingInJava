package com.shu.twentyfirstchapter.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Shows the use of thread priorities
 * setPriority(int value) value必须大于等于1并且小于等于10
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-11-22 21:20
 * @Version: 1.0.0
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d; //No optimization 建议编译器不优化

    private int cusPriotity;

    public SimplePriorities(int cusPriotity) {
        this.cusPriotity = cusPriotity;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + " -- " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(cusPriotity);//setPriority must be <=Thread.MAX_PRIORITY and >=Thread.MIN_PRIORITY
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }

            }
            System.out.println(this);

            if (--countDown == 0) {
                return;
            }
        }
    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int y = 0; y < 5; y++)
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));

        exec.shutdown();//newer deal with another threads
    }
}
