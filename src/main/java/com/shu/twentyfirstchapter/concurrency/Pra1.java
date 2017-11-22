package com.shu.twentyfirstchapter.concurrency;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-09-16 15:03
 * @Version: 1.0.0
 */
public class Pra1 implements Runnable {
    private static int count = 0;
    private final int id = count++;

    public Pra1() {
        System.out.println("Pra1.Pra1:" + id);
    }


    @Override
    public void run() {
        System.out.println("Pra1.run" + id);
        Thread.yield();
    }
}
