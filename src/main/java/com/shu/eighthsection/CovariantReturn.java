package com.shu.eighthsection;

/**
 * polymorphism/CovariantReturn.java
 * 多态/协作返回类型
 * java SE5中添加了协作返回类型：导出类中被覆盖方法可以返回基类方法的返回类更为具体的子类，
 * 不仅是基类类型(前提：返回类型存在继承关系)
 * Created by 123 on 2017/5/2.
 */
public class CovariantReturn {
    public static void main(String[] args) {
        //1.base
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);

        //2.covariant return
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}/*
Grain
Wheat
*///:~


class Grain{
    @Override
    public String toString(){
        return "Grain";
    }
}

class Wheat extends Grain{
    @Override
    public String toString(){
        return "Wheat";
    }
}

class Mill{
    Grain process(){
        return new Grain();
    }
}

class WheatMill extends Mill{
    Wheat process(){
        return new Wheat();
    }
}