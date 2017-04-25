package com.shu.seventhsection;

/**
 * resuing/Orc.class
 * The protected keyword,effect subclass and the same package class to use.
 * Created by Administrator on 2017-04-25.
 */
public class Orc extends Villain {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public void change(String name, int orcNumber) {
        set(name);
        this.orcNumber = orcNumber;
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Jony", 20);
        System.out.println(orc);

        orc.change("Tony", 19);
        System.out.println(orc);
    }
}

class Villain {
    private String name;

    protected void set(String nm) {
        name = nm;
    }

    public Villain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}/*
    Orc 20: I'm a Villain and my name is Jony
    Orc 19: I'm a Villain and my name is Tony
    */
