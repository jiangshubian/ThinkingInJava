package com.shu.Fifteenthchapter.generic;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法：
 *      可变参数和泛型方法结合
 * Created by Administrator on 2017-07-17.
 */
public class GenericVarargs {

    /**
     * 类似于java.util.Arrays.asList()方法
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        for (T t : args) result.add(t);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(makeList('b'));
        System.out.println(makeList("A","B","C"));
        System.out.println(makeList("ABCDEFGHIJKLMNOPQ".split("")));
    }
}
