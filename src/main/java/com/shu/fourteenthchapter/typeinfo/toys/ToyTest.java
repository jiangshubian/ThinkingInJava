package com.shu.fourteenthchapter.typeinfo.toys;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017-06-12.
 */
public class ToyTest implements D {

    static void printInfo(Class cc) {
        System.out.println("Class name:" + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name:" + cc.getCanonicalName());
    }

    private static class Main {
        public static void main(String[] args) throws Exception {
            Class c = null;
            try {
                c = Class.forName("com.shu.fourteenthchapter.typeinfo.toys.FancyToy");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }
            printInfo(c);
            for (Class infs : c.getInterfaces())
                printInfo(infs);

            Class supClass = c.getSuperclass();
            Object obj = null;
            try {
                //Required default constructor
                obj = supClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                System.exit(1);
            }
            printInfo(obj.getClass());

            showRelations(Class.forName("com.shu.fourteenthchapter.typeinfo.toys.ToyTest"));
            showRelations(c);

            for (Field f : c.getDeclaredFields())
                System.out.println("Field:" + f.getType() + "-" + f.getName());
        }


        public static void showRelations(Class clazz) throws Exception {
            System.out.println();
            for (Class infs : clazz.getInterfaces())
                System.out.println("Interface:" + infs.getName());
            Class supClass = clazz.getSuperclass();
            //Required default constructor
            Object obj = supClass.newInstance();
            System.out.println("Super Object:" + obj.getClass());
        }
    }
}

interface A {
}

interface B {
}

interface C {
}

interface D {
}

class Toy {
    private String name;

    //Comment out the following default constructor to see NoSuchMethodError form (*1*)
    public Toy() {// must has default constructor, id not will call exception which java.lang.InstantiationException: com.shu.fourteenthchapter.typeinfo.toys.Toy
    }

    public Toy(int i) {
    }
}

class FancyToy extends Toy implements A, B, C {
    private int age;

    public FancyToy() {
        super(1);
    }
}
/*Output:
    Class name:com.shu.fourteenthchapter.typeinfo.toys.FancyToy is interface? [false]
    Simple name:FancyToy
    Canonical name:com.shu.fourteenthchapter.typeinfo.toys.FancyToy
    Class name:com.shu.fourteenthchapter.typeinfo.toys.A is interface? [true]
    Simple name:A
    Canonical name:com.shu.fourteenthchapter.typeinfo.toys.A
    Class name:com.shu.fourteenthchapter.typeinfo.toys.B is interface? [true]
    Simple name:B
    Canonical name:com.shu.fourteenthchapter.typeinfo.toys.B
    Class name:com.shu.fourteenthchapter.typeinfo.toys.C is interface? [true]
    Simple name:C
    Canonical name:com.shu.fourteenthchapter.typeinfo.toys.C
    Class name:com.shu.fourteenthchapter.typeinfo.toys.Toy is interface? [false]
    Simple name:Toy
    Canonical name:com.shu.fourteenthchapter.typeinfo.toys.Toy
*///~
