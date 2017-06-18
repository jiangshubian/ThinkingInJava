package com.shu.fourteenthchapter.typeinfo;

import net.mindview.util.CountingGenerator;

/**
 * 类型泛化。。
 * Created by Administrator on 2017-06-17.
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> clazz = int.class;
        clazz = Integer.class;
    }
}
