package com.shu.seventhchapter;

/**
 * base class
 * Created by Administrator on 2017-04-26.
 */
public class Amphibian {
    /**
     * a name
     */
    protected String name;

    /**
     * constructor
     * @param name the name what you want to set.
     */
    public Amphibian(String name) {
        this.name = name;
    }

    /**
     * the get name method for all subclass
     * @return the name what subclass set
     */
    protected String getName(){
        return name;
    }

    /**
     * print test message for this method
     */
    public void doSomethings(){
        System.out.println("Today is rainning....");
    }
}
