package com.shu.Fifteenthchapter.generic;

import java.util.Iterator;

/**
 * @author: jiangshubian
 * @Description: 适配器模式，对Fobonacci进行适配并拓展功能,使用组合替换继承。
 * @Date: Create in 2017-07-16 22:44
 * @Version: 1.0.0
 */
public class FobonacciIterableCombinationalAdapter implements Iterable<Integer> {
    private int n;
    private Fobonacci fobonacci;

    /**
     * 构造器
     *
     * @param count 显示个数
     */
    public FobonacciIterableCombinationalAdapter(int count) {
        if (count <= 0) throw
                new IllegalArgumentException("[count must be gather than 0, but now is " + count + " ]");
        this.n = count;
        this.fobonacci = new Fobonacci();
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
                return fobonacci.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer i : new FobonacciIterableCombinationalAdapter(20)) System.out.print(i + " ");
    }
}
