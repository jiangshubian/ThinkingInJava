package com.shu.twentyfirstchapter.concurrency.caughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 其他线程异常，Main主入口异常无法捕获
 * Created by Administrator on 2017/12/2.
 */
public class ExecptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException("主动抛出异常！");
    }

    public static void main(String[] args) {
        //即使加了try..catch..也无法捕获异常
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExecptionThread());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
