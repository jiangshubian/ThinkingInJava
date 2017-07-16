package com.shu.Fifteenthchapter.generic;

import com.shu.util.Generator;

/**
 * @author: jiangshubian
 * @Description: 斐波那契数列
 * @Date: Create in 2017-07-16 22:33
 * @Version: 1.0.0
 */
public class Fobonacci implements Generator<Integer> {
    /**
     * 定义顺序
     */
    private int count = 0;

    public Integer next() {
        return fib(count++);
    }

    public int fib(int n) {//n为第几个
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        Fobonacci fobonacci = new Fobonacci();
        for (int i=0;i<20;i++) {
            System.out.print(fobonacci.next()+" ");
        }
    }
}
