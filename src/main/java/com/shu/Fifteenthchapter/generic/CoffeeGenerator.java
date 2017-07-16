package com.shu.Fifteenthchapter.generic;

import com.shu.Fifteenthchapter.generic.coffee.Cappuccino;
import com.shu.Fifteenthchapter.generic.coffee.Coffee;
import com.shu.Fifteenthchapter.generic.coffee.Latte;
import com.shu.Fifteenthchapter.generic.coffee.Mocha;
import com.shu.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author: jiangshubian
 * @Description: Coffee生成器
 * @Date: Create in 2017-07-16 21:34
 * @Version: 1.0.0
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class};//Init data
    private static Random random = new Random(47);

    /**
     * 无参构造
     */
    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    private int size = 0;//For Iteration

    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 自定义Iterator
     */
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * The Iterable interface of iterator method 实现
     *
     * @return Iterator<Coffee>
     */
    public Iterator<Coffee> iterator() {
        System.out.println("CoffeeGenerator.iterator");
        return new CoffeeIterator();
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        CoffeeGenerator coffees = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffees.next());
        }

        //调用了Iterator()方法
        coffees = new CoffeeGenerator(5);
        Iterator<Coffee> it = coffees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //CoffeeGenerator属于Iterable接口，可以直接循环
        //CoffeeGenerator implementing Iterable interface then allows to be the target of the "foreach" statement.
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
