package com.shu.Fifteenthchapter.generic;

/**
 * 创建类型实例方式一：工厂对象
 * 要求实例化对象必须具备无参构造，否则java.lang.InstantiationException错误
 * Created by Administrator on 2017-07-22.
 */
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> employee = new ClassAsFactory<Employee>(Employee.class);
        System.out.println(employee.x.getClass().getSimpleName());
        try {
            ClassAsFactory<Integer> in = new ClassAsFactory<Integer>(Integer.class);//运行时才检查出错
        } catch (Exception e) {
            System.out.println("InstantiationException failure..");
        }

    }
}


class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> type) {
        try {
            x = type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

class Employee {}