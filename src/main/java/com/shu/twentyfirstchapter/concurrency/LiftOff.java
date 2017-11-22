package com.shu.twentyfirstchapter.concurrency;

/**
 * @author: jiangshubian
 * @Description: Implememnt Runnable class
 * @Date: Create in 2017-09-16 14:34
 * @Version: 1.0.0
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    /**
     * Print current subThread status
     *
     * @return
     */
    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LifeOff!") + ") ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
