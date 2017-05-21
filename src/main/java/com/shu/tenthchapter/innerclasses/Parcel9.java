package com.shu.tenthchapter.innerclasses;

/**
 * 你们内部类中引用外部参数作为属性的值，外部参数必须定义为final.
 * Created by Administrator on 2017-05-21.
 */
public class Parcel9 {
    //Argument must be final to use inside anonymous inner class.
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            String f() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p9 = new Parcel9();
        System.out.println(p9.destination("shu").f());
    }
}

abstract class Destination {
    abstract String f();
}