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
public class EvenGeneratorError extends IntGenerator {
    private int currentEvenValue = 0;

    //无法保证return currentEvenValue;执行
    @Override
    public int next() {
        add();
        return currentEvenValue;
    }

    private synchronized void add() {
        System.out.println("add:" + Thread.currentThread());
        ++currentEvenValue;
        Thread.yield();//模拟线程让出cpu执行权，增加其他线程执行：return currentEvenValue;概率
        add2();
    }

    private synchronized void add2() {
        System.out.println("add2:" + Thread.currentThread());
        ++currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGeneratorError());
    }
}
