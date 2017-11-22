package com.shu.twentyfirstchapter.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-10-28 12:35
 * @Version: 1.0.0
 */
public class ExecutorSubmit {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        testOne();
        testTwo();
    }

    private static void testOne() throws InterruptedException, ExecutionException {
        int num = 100;
        ExecutorService exec = Executors.newCachedThreadPool();

        List<Future<Integer>> sum = new ArrayList<Future<Integer>>(num);

        for (int i = 0; i < num; i++)
            sum.add(exec.submit(new Countor(), num));
        int amount = 0;
        for (Future<Integer> future : sum)
            amount += future.get();
        System.out.println(amount);
        System.exit(0);//exit
    }

    private static void testTwo() throws InterruptedException, ExecutionException {
        int num = 10;
        ExecutorService exec = Executors.newCachedThreadPool();

        List<Future<?>> sum = new ArrayList<Future<?>>(num);

        for (int i = 0; i < num; i++)
            sum.add(exec.submit(new Countor()));
        for (Future<?> future : sum)
            System.out.println(future.get());//Notify: return null
        System.exit(0);//exit
    }

    static class Countor implements Runnable {
        private static int count = 0;
        private static AtomicInteger atomicInteger = new AtomicInteger(count);

        private int id = atomicInteger.incrementAndGet();

        @Override
        public void run() {
            System.out.println("Countor identifies is :" + id);
            Thread.yield();
        }
    }

}
