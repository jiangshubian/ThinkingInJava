package com.shu.eleventhchapter.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017-05-30.
 */
public class Pets implements Serializable {
    private static final long serialVersionUID = -3567578596206481387L;
    private int id;
    private String name;

    public Pets(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pets() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void eat() {
        System.out.println("Pets.eat");
    }

    public static List<Pets> arrayList(int count) {
        List<Pets> list = new ArrayList<Pets>();
        for (int i = 0; i < count; i++) {
            list.add(new Pets(i, String.valueOf(i)));
        }
        return list;
    }

    public static Pets randomPet() {
        int random = new Random().nextInt(100);
        return new Pets(random, String.valueOf(random));
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
