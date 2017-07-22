package com.shu.Fifteenthchapter.generic;

import java.util.ArrayList;

/**
 * 泛型类型檫除
 * Created by Administrator on 2017-07-22.
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class in = new ArrayList<Integer>().getClass();
        Class str = new ArrayList<String>().getClass();
        System.out.println(in == str);
    }
}/* Output:
true
*///~
