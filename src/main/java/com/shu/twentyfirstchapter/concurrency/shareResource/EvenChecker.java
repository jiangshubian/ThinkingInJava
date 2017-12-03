package com.shu.twentyfirstchapter.concurrency.shareResource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-12-03 20:33
 * @Version: 1.0.0
 */
public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println(this + " i:" + id);
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (val % 2 != 0) {
                intGenerator.cancel();
                System.out.println(Thread.currentThread()+" val:"+val + " not even!");
            }
        }
    }


    public static void test(IntGenerator gp, final int count) {
        System.out.println("Please Control-C to exit.");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
            exec.execute(new EvenChecker(gp, i));
        exec.shutdown();
    }

    //Default value for count.
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
