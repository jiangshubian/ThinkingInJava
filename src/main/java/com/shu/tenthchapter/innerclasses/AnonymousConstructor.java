package com.shu.tenthchapter.innerclasses;

/**
 * Created by Administrator on 2017-05-21.
 */
public class AnonymousConstructor {
    public static Base getBase(int init){
        return new Base(init) {
            @Override
            public void f() {
                System.out.println("f method is been inited..."+i);
            }
        };
    }

    public static void main(String[] args) {
        AnonymousConstructor.getBase(10).f();
    }
}

abstract class Base {
    protected int i;
    public Base(int i) {
        System.out.println("i:" + i);
        this.i=i;
    }
    public abstract void f();
}