package com.shu.twentyfirstchapter.concurrency;

import org.junit.Test;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-09-16 14:48
 * @Version: 1.0.0
 */
public class MainThread {

    @Test
    public void commonTask() {
        //Common task
        LiftOff liftOff = new LiftOff();
        liftOff.run();
        System.out.println("MainThread.commonTask");
    }

    @Test
    public void basicThreads() {
        new Thread(new LiftOff()).start();
        System.out.println("MainThread.threadTask");
    }

    @Test
    public void moreBasicThreads() {
        for (int i = 0; i < 5; i++) {
            basicThreads();
        }
    }


    @Test
    public void par1Test(){
        for (int i = 0; i < 3; i++) {
            new Thread(new Pra1()).start();
        }
    }


    @Test
    public void par2Test(){
        for (int i = 3; i <= 12; i++) {
            new Thread(new Pra2(i)).start();
        }
    }
}
