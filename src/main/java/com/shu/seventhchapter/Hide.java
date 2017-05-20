package com.shu.seventhchapter;

/**
 * reusing/Hide.java
 * Overloading a base-class method name in a drived
 * class does not hide the base-class version.
 * 重载父类同名方法,在重写父类方法时，使用注解@Override来增强重写标识，避免出错.
 * Created by Administrator on 2017-04-25.
 */
public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(10.0f);
        b.doh(new Milhouse());
    }
}

class Homer{
    char doh(char c){
        System.out.println("Home.doh(char)");
        return 'a';
    }
    float doh(float f){
        System.out.println("Home.doh(float)");
        return 1.0f;
    }
}

class Milhouse{}

class Bart extends Homer{
    void doh(Milhouse m){
        System.out.println("Bart.doh(Milhouse)");
    }
    @Override
    char doh(char c){
        super.doh(c);
        System.out.println("Bart.doh(char)");
        return 'b';
    }
}