package com.shu.tenthchapter.innerclasses;

/**
 * 嵌套类，成员内部类是静态的类，无法使用外部类.this调用到外部对象。
 * Created by Administrator on 2017-05-21.
 */
public class Parcel11 {
    public static Obj obj1(final String n) {
        return new Obj() {
            public Obj2 obj2() {
                return new Obj2() {
                    public String f() {
                        return n;
                    }
                };
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(obj1("shu").obj2().f());
    }
}

abstract class Obj {
    public abstract Obj2 obj2();
}

interface Obj2 {
    public String f();
}