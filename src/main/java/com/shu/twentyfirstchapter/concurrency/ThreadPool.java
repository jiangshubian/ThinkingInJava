package com.shu.twentyfirstchapter.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: jiangshubian
 * @Description: use Executors
 * @Date: Create in 2017-09-16 15:12
 * @Version: 1.0.0
 */
public class ThreadPool {
    @Test
    public void cachedThreadPool() {
        ExecutorService cached = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            cached.execute(new LiftOff());
        cached.shutdown();
//        exec.execute(new LiftOff()); //Rejected Execution:java.util.concurrent.RejectedExecutionException
    }


    @Test
    public void fixedThreadPool() {
        final int nThreads = 5;
        ExecutorService fixed = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; i++)
            fixed.execute(new LiftOff());
        fixed.shutdown();
    }


    @Test
    public void singleThreadPool() {
        ExecutorService single = Executors.newSingleThreadExecutor();
        ExecutorService singleFixed = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++)
            single.execute(new LiftOff());
        single.shutdown();
        for (int i = 0; i < 5; i++)
            singleFixed.execute(new LiftOff());
        singleFixed.shutdown();
    }

}
