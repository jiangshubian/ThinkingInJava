package com.shu.ninthsection;

/**
 * Created by Administrator on 2017-05-04.
 */
public class AbstractPraSub extends AbstractPraBase {
    public void print(){
        System.out.println("AbstractPraSub.print");
    }

    public static void show(){
        AbstractPraBase a = new AbstractPraSub();
        ((AbstractPraSub)a).print();//before base class don't have an abstract method.
    }

    public static void showSpuer(){
        AbstractPraBase a = new AbstractPraSub();
        a.print();
    }
}
