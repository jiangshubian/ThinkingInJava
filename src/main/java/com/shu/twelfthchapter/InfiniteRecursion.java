package com.shu.twelfthchapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 无意识递归
 * toString中使用"+"与this拼接时候，this会再次调用toString()方法都在出现递归。
 * Created by Administrator on 2017-06-04.
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        return "InfiniteRecursion address: " + super.toString() + "\n";
//        return "InfiniteRecursion address: " + this + "\n";
        //this :Exception in thread "main" java.lang.StackOverflowError
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> irLis = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 20; i++) {
            irLis.add(new InfiniteRecursion());
        }
        System.out.println(irLis);
    }

}
