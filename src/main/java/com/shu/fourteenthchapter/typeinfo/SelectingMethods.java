package com.shu.fourteenthchapter.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017-07-03.
 */
public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods someMethods = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        someMethods.eating();
        someMethods.intersting();
        someMethods.intersting("Sleep..");
    }
}

interface SomeMethods {
    void intersting();

    void intersting(String args);

    void eating();
}

class Implementation implements SomeMethods {

    @Override
    public void intersting() {
        System.out.println("Implementation.intersting");
    }

    @Override
    public void intersting(String args) {
        System.out.println("Implementation.intersting");
    }

    @Override
    public void eating() {
        System.out.println("Implementation.eating");
    }
}

class MethodSelector implements InvocationHandler {
    private Object proxy;

    public MethodSelector(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting")) System.out.println("Proxy detected the intersting method.");
        return method.invoke(proxy, args);
    }
}