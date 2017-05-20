package com.shu.fifthchapter;

import java.io.Serializable;

/**
 * 数据定义和使用三种方式
 * Created by Administrator on 2017-04-11.
 */
public class DynamicArray implements Serializable {
    public static void main(String[] args) {
        //1.
        String[] first = new String[2];
        first[0] = "shu";
        first[1] = "boy";
        Other.main(first);
        System.out.println();
        //2.
        String[] second = {"abc", "def"};
        Other.main(second);
        System.out.println();
        //3.
        Other.main(new String[]{"thirth", "girl"});


        //4.
        System.out.println();
        //练习：
        Tree[] t; //只定义变量，没赋值
        t = new Tree[]{new Tree("heqiehua")}; //给数组赋予对象，期间将对数组中对象进行初始化工作
    }/* Output:
        s:shu
        s:boy

        s:abc
        s:def

        s:thirth
        s:girl
    */
}

class Other {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println("s:" + s);
        }
    }
}

class Tree {
    private String name;

    public Tree(String name) {
        this.name = name;
        System.out.println("name:" + name);
    }
}