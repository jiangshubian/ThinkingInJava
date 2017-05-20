package com.shu.fifthchapter;

import java.io.Serializable;

/**
 * Created by 123 on 2017/4/9.
 */
public class Person implements Serializable {
    String name;
    String likes = "girl";

    public Person() {
        System.out.println("name:" + name);
        System.out.println("likes:" + likes);
    }

    public Person(String name) {
        this.name = name;
        System.out.println("name:" + name);
        System.out.println("likes:" + likes);
    }
}
