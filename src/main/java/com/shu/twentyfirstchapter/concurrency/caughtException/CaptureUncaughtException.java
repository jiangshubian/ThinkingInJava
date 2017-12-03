package com.shu.twentyfirstchapter.concurrency.caughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Uncaught处理优先级：
 * 1、ThreadFactory中自定义的UncaughtExceptionHandler
 * 2、线程组中定义的UncaughtExceptionHandler
 * 3、否则使用线程默认的DefaultUncaughtExceptionHandler
 * <p>
 * Created by Administrator on 2017/12/2.
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        //Defined Thread Group UncaughtExceptionHandler,ignore if ThreadFactory have custom UncaughtExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler2());
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException("主动抛出异常！");
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("eh = " + t.getUncaughtExceptionHandler() + ",Caught: " + e+" thread: "+t);
    }
}

class MyUncaughtExceptionHandler2 implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("eh2 = " + t.getUncaughtExceptionHandler() + ",Caught2: " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread.");
        Thread t = new Thread(r);
        System.out.println("Created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}