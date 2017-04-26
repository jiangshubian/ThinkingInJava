package com.shu.seventhsection;

import java.util.Random;

/**
 * reusing/BlankFinal.class
 * Created by Administrator on 2017-04-26.
 */
public class BlankFinal {
    private static boolean fianlFlag = false;
    private static final String CLASS_NAME = "BlankFinal";
    private final int i = 0; //Initialized final
    private final int j; // White final
    private final Poppet p;

    public BlankFinal() {
        this.p = new Poppet(1);
        System.out.println("BlankFinal.BlankFinal--111");
    }

    public BlankFinal(int x) {
        this.p = new Poppet(x);
        System.out.println("BlankFinal.BlankFinal--222");
    }

    //Blank finals MUST be initialized in the object block or constructor
    {
        j = new Random(47).nextInt(10); //Initialized black final
        System.out.println("BlankFinal.instance initializer--block");
    }

    @Override
    public String toString() {
        return "BlankFinal.toString:" + j + ";p:" + p;
    }

    public static void main(String[] args) {
        BlankFinal b1 = new BlankFinal();
        BlankFinal b2 = new BlankFinal(10);
        System.out.println(b1);
        System.out.println(b2);
    }
}
/*
BlankFinal.instance initializer--block
BlankFinal.BlankFinal--111
BlankFinal.instance initializer--block
BlankFinal.BlankFinal--222
BlankFinal.toString:1;p:Poppet{i=1}
BlankFinal.toString:1;p:Poppet{i=10}
* */

class Poppet {
    private int i;

    public Poppet(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Poppet{" +
                "i=" + i +
                '}';
    }
}