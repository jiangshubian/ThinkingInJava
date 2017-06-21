package com.shu.fourteenthchapter.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import static com.shu.fourteenthchapter.typeinfo.Interface.name;
import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * 1、创建代理实现类(implement InvocationHandler)
 * 2、使用Proxy.newInstance(1,2,3)生成代理对象
 * 总结
 * 一个典型的动态代理创建对象过程可分为以下四个步骤：
 * 1、通过实现InvocationHandler接口创建自己的调用处理器 IvocationHandler handler = new InvocationHandlerImpl(...);
 * 2、通过为Proxy类指定ClassLoader对象和一组interface创建动态代理类
 * Class clazz = Proxy.getProxyClass(classLoader,new Class[]{...});
 * 3、通过反射机制获取动态代理类的构造函数，其参数类型是调用处理器接口类型
 * Constructor constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});
 * 4、通过构造函数创建代理类实例，此时需将调用处理器对象作为参数被传入
 * Interface Proxy = (Interface)constructor.newInstance(new Object[] (handler));
 * 为了简化对象创建过程，Proxy类中的newInstance方法封装了2~4，只需两步即可完成代理对象的创建。
 * 生成的ProxySubject继承Proxy类实现Subject接口，实现的Subject的方法实际调用处理器的invoke方法，
 * 而invoke方法利用反射调用的是被代理对象的的方法（Object result=method.invoke(proxied,args)）
 * <p>
 * 美中不足
 * 诚然，Proxy已经设计得非常优美，但是还是有一点点小小的遗憾之处，那就是它始终无法摆脱仅支持interface代理的桎梏，
 * 因为它的设计注定了这个遗憾。回想一下那些动态生成的代理类的继承关系图，它们已经注定有一个共同的父类叫Proxy。
 * Java的继承机制注定了这些动态代理类们无法实现对class的动态代理，原因是多继承在Java中本质上就行不通。
 * 有很多条理由，人们可以否定对 class代理的必要性，但是同样有一些理由，相信支持class动态代理会更美好。
 * 接口和类的划分，本就不是很明显，只是到了Java中才变得如此的细化。如果只从方法的声明及是否被定义来考量，
 * 有一种两者的混合体，它的名字叫抽象类。实现对抽象类的动态代理，相信也有其内在的价值。此外，还有一些历史遗留的类，
 * 它们将因为没有实现任何接口而从此与动态代理永世无缘。
 * 如此种种，不得不说是一个小小的遗憾。但是，不完美并不等于不伟大，伟大是一种本质，Java动态代理就是佐例。
 * Created by Administrator on 2017-06-21.
 */
public class SimpleDynamicProxy {
    private static void consumer(Interface anInterface) {
        anInterface.doSomething();
        anInterface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject ro = new RealObject();
        consumer(ro);

        //Insert a proxy and call again:
        InvocationHandler invocationHandler = new DynamicInvocationHandler(ro);
        InvocationHandler invocationHandler2 = new DynamicInvocationHandler(new SimpleProxy(ro));
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                invocationHandler);
        System.out.println(proxy.name); //调用属性值不触发代理
        consumer(proxy);//调用被代理方法时才触发代理
        System.out.println(DynamicInvocationHandler.getInvokeMethodCount());//统计被代理调用的方法度量
    }
}

class DynamicInvocationHandler implements InvocationHandler {
    private Object proxied;

    public DynamicInvocationHandler(Object proxied) {
        this.proxied = proxied;
    }

    private static int invokeMethodCount = 0;

    /**
     * invoke方法中,代理的方法调用次数度量
     *
     * @return 调用次数
     */
    public static int getInvokeMethodCount() {
        return invokeMethodCount;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在转调具体目标对象之前，可以执行一些功能处理
        System.out.println("*** proxy: " + proxy.getClass().getName() + ", method: " + method.getName() + ", args: " + Arrays.toString(args));
        if (args != null) {
            for (Object arg : args) {
                System.out.println("    " + arg.getClass().getName());
            }
        }
        invokeMethodCount++;
        return method.invoke(proxied, args);
        //在转调具体目标对象之后，可以执行一些功能处理
    }
}/*
RealObject.doSomething
args = bonobo
*** proxy: com.shu.fourteenthchapter.typeinfo.$Proxy0, method: doSomething, args: null
RealObject.doSomething
*** proxy: com.shu.fourteenthchapter.typeinfo.$Proxy0, method: somethingElse, args: [bonobo]
    java.lang.String
args = bonobo
*////:~