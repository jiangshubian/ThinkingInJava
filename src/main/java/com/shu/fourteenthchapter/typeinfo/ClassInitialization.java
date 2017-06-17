package com.shu.fourteenthchapter.typeinfo;

import java.util.Random;

/**
 * Created by Administrator on 2017-06-17.
 */
public class ClassInitialization {
    public static Random r = new Random(47);

    public static void main(String[] args) {
        Class<Initable> initableClass = Initable.class;
        System.out.println("After creating Initable ref.");
        System.out.println(Initable.STATIC_FINAL_VAL);
        System.out.println(Initable.STATIC_FINAL_VAL2);
        System.out.println(Initable2.static_val);
        try {
            Class.forName("com.shu.fourteenthchapter.typeinfo.Initable3");//Class.forName('完整包路径+类名');
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("After creating Initable3 ref.");
        System.out.println(Initable3.static_val);
    }
}

class Initable {
    static final int STATIC_FINAL_VAL = 47;
    static final int STATIC_FINAL_VAL2 = ClassInitialization.r.nextInt(1000);

    static {
        System.out.println("Initable.static initializer");
    }
}

class Initable2 {
    static int static_val = 147;

    static {
        System.out.println("Initable2.static initializer");
    }
}

class Initable3 {
    static int static_val = 247;

    static {
        System.out.println("Initable3.static initializer");
    }
}/*Output:
    After creating Initable ref.
    47
    Initable.static initializer
    258
    Initable2.static initializer
    147
    Initable3.static initializer
    After creating Initable3 ref.
    247
*///~
