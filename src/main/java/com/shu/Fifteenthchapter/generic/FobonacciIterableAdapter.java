package com.shu.Fifteenthchapter.generic;

import java.util.Iterator;

/**
 * @author: jiangshubian
 * @Description: 适配器模式，对Fobonacci进行适配并拓展功能
 * @Date: Create in 2017-07-16 22:44
 * @Version: 1.0.0
 */
public class FobonacciIterableAdapter extends Fobonacci implements Iterable<Integer> {
    private int n;

    public FobonacciIterableAdapter(int count) {
        this.n = count;
    }

    /**
     * 实现Iterable接口的iterator()方法
     *
     * @return
     */
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() { //匿名实现
            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                n--;
                return FobonacciIterableAdapter.this.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer i : new FobonacciIterableAdapter(18)) {
            System.out.print(i+" ");
        }

    }
}
