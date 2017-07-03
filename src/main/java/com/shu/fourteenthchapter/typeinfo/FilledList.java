package com.shu.fourteenthchapter.typeinfo;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * FilledList类与其他类一同工作时，其他类必须有默认的无参构造，否则报错：
 * java.lang.InstantiationException: com.shu.fourteenthchapter.typeinfo.CountInteger
 * 使用泛化用于Class对象时，通过newInstance()将返回切确泛化的对象类型。
 * Created by Administrator on 2017-06-17.
 */
public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList filledList = new FilledList<CountInteger>(CountInteger.class);
        System.out.println(filledList.create(10));
    }
}

class CountInteger {
    private static long counter;
    private final long id = counter++;

//    public CountInteger(int a) {
//    }

    @Override
    public String toString() {
        return Long.toString(id);
    }
}