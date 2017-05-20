package com.shu.seventhchapter;

/**
 * subclass
 * Created by Administrator on 2017-04-26.
 */
public class Frog extends Amphibian {
    /**
     * constructor
     * @param name the name what you want to set.
     */
    public Frog(String name) {
        super(name);
    }

    @Override
    public void doSomethings() {
        System.out.println("Frog.doSomethings");
    }

    public void  mySelfMethod(){
        System.out.println("Frog.mySelfMethod");
    }
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        //向上转型 无法调用子类特有方法
        Amphibian f = new Frog("shu");
        System.out.println(f.getName()); //shu
        f.doSomethings(); //Frog.doSomethings

        //向下转型
        if(f instanceof Frog)((Frog)f).mySelfMethod();//调用子类自有方法
    }


}
/*
    shu
    Frog.doSomethings
    Frog.mySelfMethod
* */