package com.shu.fourteenthchapter.typeinfo;

import static sun.java2d.cmm.ColorTransform.In;

/**
 * Created by Administrator on 2017-06-21.
 */
public class SimpleProxyDemo {
    public static void consumer(Interface anInterface) {
        anInterface.doSomething();
        anInterface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("RealObject.doSomething");
    }

    public void somethingElse(String args) {
        System.out.println("args = " + args);
    }
}

class SimpleProxy implements Interface {
    protected Interface anInterface;

    public SimpleProxy(Interface anInterface) {
        this.anInterface = anInterface;
    }

    public void doSomething() {
        System.out.println("SimpleProxy.doSomething");
        anInterface.doSomething();
    }

    public void somethingElse(String args) {
        System.out.println("args = " + args);
        anInterface.somethingElse(args);
    }
}

interface Interface {
    String name = "interface";

    void doSomething();

    void somethingElse(String args);
}