package com.shu.twentyfirstchapter.concurrency;

import com.shu.fourthchapter.Fibonacci;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-09-16 15:57
 * @Version: 1.0.0
 */
public class Pra2 implements Runnable {
    private int num;

    public Pra2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Fibonacci.getFibonacciNumbers(num));
        System.out.println("Pra2.run：" + num);
        Thread.yield();
    }
}
