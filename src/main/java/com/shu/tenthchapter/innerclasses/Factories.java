package com.shu.tenthchapter.innerclasses;

/**
 * 使用接口体现工厂方法设计模式,使用匿名内部类创建对象
 * Created by Administrator on 2017-05-20.
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory sf) {
        Service s = sf.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(ImplementService1.factory);
        serviceConsumer(ImplementService2.factory);
    }
}

//业务接口
interface Service {
    void method1();

    void method2();
}

//业务接口实现1
class ImplementService1 implements Service {
    private  ImplementService1(){}
    public void method1() {
        System.out.println("ImplementService1.method1");
    }

    public void method2() {
        System.out.println("ImplementService1.method2");
    }

    //创建接口实例化对象的匿名内部类
    public static ServiceFactory factory = new ServiceFactory(){
        public Service getService() {
            return new ImplementService1();
        }
    };
}

//业务接口实现2
class ImplementService2 implements Service {
    private  ImplementService2(){}
    public void method1() {
        System.out.println("ImplementService2.method1");
    }

    public void method2() {
        System.out.println("ImplementService2.method2");
    }

    //创建接口实例化对象的匿名内部类
    public static ServiceFactory factory = new ServiceFactory(){
        public Service getService() {
            return new ImplementService2();
        }
    };
}

//工厂方法接口
interface ServiceFactory {
    Service getService();
}
