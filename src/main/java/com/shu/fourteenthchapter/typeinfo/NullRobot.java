package com.shu.fourteenthchapter.typeinfo;

import com.shu.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * 空对象代理类调用类方法定义
 * Created by Administrator on 2017-07-09.
 */
public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotProxyHandler(type));
    }

    public static void main(String[] args) {
        Robot[] robots = {
                new SnowCleanRobot("Snow Robot"),
                newNullRobot(SnowCleanRobot.class) //返回SnowCleanRobot的代理类
        };
        for (Robot r : robots) Robot.Test.test(r);
    }
}

/**
 * 空对象代理类
 */
class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;

    private Robot proxied = new NRobot();//内嵌空对象对象

    public NullRobotProxyHandler(Class<? extends Robot> type) {
        this.nullName = type.getSimpleName() + " NullRobot.";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getSimpleName()); //Show proxy class simple name  result:$Proxy0
        System.out.println(method.getName()); //Show method name
        System.out.println("args:"+args); //Show args value
        return method.invoke(proxied, args);
    }

    class NRobot implements Null, Robot {

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
}
