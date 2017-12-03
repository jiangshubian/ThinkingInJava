package com.shu.twentyfirstchapter.concurrency.shareResource;

/**
 * 任务调用任意个synchronized代码块时，依次累积对同一对象加锁，
 * 执行完synchronized代码块依次减少锁到0，即是否对象锁。
 *
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-12-03 20:40
 * @Version: 1.0.0
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    //方式一：
//    @Override
//    public synchronized int next() {
//        ++currentEvenValue;
//        ++currentEvenValue;
//        return currentEvenValue;
//    }

    //方式二
    @Override
    public int next() {
        synchronized (this) {
            add();
            return currentEvenValue;
        }
    }


    private synchronized void add() {
        System.out.println("add:" + Thread.currentThread());
        ++currentEvenValue;
        add2();
    }

    private synchronized void add2() {
        System.out.println("add2:" + Thread.currentThread());
        ++currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
