package com.shu.tenthchapter.innerclasses;

/**
 * 匿名内部类使用代码块实例化
 * Created by Administrator on 2017-05-21.
 */
public class Parcel10 {
    //Argument must be final to use inside anonymous inner class.
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;

            {
                cost = Math.round(price);
                if (cost > 100) System.out.println("Gather than 100,is: " + cost);
            }

            private String label = dest;

            String f() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p10 = new Parcel10();
        System.out.println(p10.destination("shu", 200.27288F).f());
    }
}
