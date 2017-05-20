package com.shu.ninthsection.interfaces;

/**
 * 使用接口体现工厂方法设计模式
 * Created by Administrator on 2017-05-20.
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory sf) {
        Service s = sf.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory1());
        serviceConsumer(new Implementation1Factory2());
    }
}

//业务接口
interface Service {
    void method1();

    void method2();
}

//业务接口实现1
class ImplementService1 implements Service {

    public void method1() {
        System.out.println("ImplementService1.method1");
    }

    public void method2() {
        System.out.println("ImplementService1.method2");
    }
}

//业务接口实现2
class ImplementService2 implements Service {

    public void method1() {
        System.out.println("ImplementService2.method1");
    }

    public void method2() {
        System.out.println("ImplementService2.method2");
    }
}

//工厂方法接口
interface ServiceFactory {
    Service getService();
}

class Implementation1Factory1 implements ServiceFactory {
    //创建对象
    public Service getService() {
        return new ImplementService1();
    }
}

class Implementation1Factory2 implements ServiceFactory {
    //创建对象
    public Service getService() {
        return new ImplementService2();
    }
}
