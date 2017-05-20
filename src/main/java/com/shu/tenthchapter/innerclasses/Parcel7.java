package com.shu.tenthchapter.innerclasses;

/**
 * Created by Administrator on 2017-05-20.
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() { //Insert a class definition
            public int value() {
                return i;
            }
        };// Semicolon required in this case
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c);
        System.out.println(c.value());
    }
}

//基类或者接口
//abstract class Contents {
//    int i = 10;
//    public abstract int value();
//}

interface Contents {
    int i = 10;
    public int value();
}

//普通类无需实现
//class Contents {
//    int i = 10;
//    public int value(){return 0;};
//}