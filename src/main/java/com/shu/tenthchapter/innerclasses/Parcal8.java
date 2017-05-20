package com.shu.tenthchapter.innerclasses;

/**
 * 匿名内部类针对有参构造的抽象类
 * Created by Administrator on 2017-05-20.
 */
public class Parcal8 {
    public Wrapping wrapping(int i) {
        return new Wrapping(i) {
            public int values() {
                return super.values() * 47;
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(new Parcal8().wrapping(10).values());
    }
}

abstract class Wrapping {
    private int i;

    public Wrapping(int i) {
        this.i = i;
    }

    public int values() {
        return i;
    }

    ;
}