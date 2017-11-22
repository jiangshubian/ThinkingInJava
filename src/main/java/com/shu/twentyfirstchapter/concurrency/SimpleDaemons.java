package com.shu.twentyfirstchapter.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-11-22 22:01
 * @Version: 1.0.0
 */
public class SimpleDaemons implements Runnable {
    private static boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 自定义后台线程功能的线程工厂
     */
    private static class DeamonThreadFactory implements ThreadFactory {
        private static int count = 0;

        @Override
        public Thread newThread(Runnable r) {
            Thread tf = new Thread(r);
            tf.setDaemon(true);                 //定义改线程是否未后台线程
            tf.setName(String.valueOf(++count));//定义改线程的名称
            tf.setPriority(Thread.NORM_PRIORITY); //定义线程处理优先级
            tf.setUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()); //定义UncaughtExceptionHandler
            tf.setContextClassLoader(this.getClass().getClassLoader()); //定义类加载器
            return tf;
        }
    }


    /**
     * 继承ThreadPoolExecutor类，重写具有ThreadFactory参数的构造器
     */
    private static class DeamonThreadPoolExecutor extends ThreadPoolExecutor {

        public DeamonThreadPoolExecutor(ThreadFactory threadFactory) {
            super(10, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), threadFactory);
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        testDefaultThread();
//        testWithThreadFactory();
        cusThreadPoolExecutor();
    }

    private static void testDefaultThread() throws InterruptedException {
        for (int y = 0; y < 5; y++) {
            Thread daemons = new Thread(new SimpleDaemons());
            daemons.setDaemon(true);
            daemons.start();
        }

        System.out.println("All daemon start...");
        TimeUnit.MICROSECONDS.sleep(200);
    }

    private static void testWithThreadFactory() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DeamonThreadFactory());
        for (int y = 0; y < 5; y++)
            exec.execute(new SimpleDaemons());

        System.out.println("All daemon start...");
        TimeUnit.MICROSECONDS.sleep(200);
    }

    private static void cusThreadPoolExecutor() throws InterruptedException {
        ExecutorService exec = new DeamonThreadPoolExecutor(new DeamonThreadFactory());
        for (int y = 0; y < 5; y++)
            exec.execute(new SimpleDaemons());

        System.out.println("All daemon start...");
        TimeUnit.MICROSECONDS.sleep(200);
    }
}
