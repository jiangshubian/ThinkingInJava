package com.shu.tenthchapter.innerclasses;

/**
 * Created by Administrator on 2017-05-25.
 */
public class LocalInnerClass {
    private int count = 0;

    Counter getCount(final String name) {
        //A local inner class
        class LocalCounter implements Counter {
            public LocalCounter() {
                //Local inner class can have a constructor
                System.out.println("LocalCounter.LocalCounter");
            }

            public int next() {
                //Access local final
                System.out.print(name + " ");
                return count++;
            }
        }
        return new LocalCounter();
    }

    //The same thing with an anonymous inner class
    Counter getCount2(final String name) {
        return new Counter() {
            //A anonymous inner class can't have a named constructor. only an instance initializer.
            {
                System.out.println("LocalInnerClass.instance");
            }

            public int next() {
                System.out.print(name + " ");
                return count++;
            }
        };
    }

    public static class Test {
        public static void main(String[] args) {
            LocalInnerClass lic = new LocalInnerClass();
            Counter c1 = lic.getCount("Local innert"), c2 = lic.getCount2("Anonymous inner");
            for (int i = 0; i < 4; i++) System.out.println(c1.next());
            for (int i = 0; i < 4; i++) System.out.println(c2.next());
        }
    }
}

interface Counter {
    int next();
}