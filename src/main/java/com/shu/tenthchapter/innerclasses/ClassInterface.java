package com.shu.tenthchapter.innerclasses;

/**
 * 接口内部类
 * Created by Administrator on 2017-05-21.
 */
public interface ClassInterface {
    void howdy();

    class Test implements  ClassInterface,ThirthInterface{
        protected String name;

        public Test(String name) {
            this.name = name;
        }

        public void howdy() {
            System.out.println("how dy!");
        }

        public static void main(String[] args) {
            new Test("bian").howdy();
        }

        public String getName() {
            return name;
        }
    }
    interface  ClassInterface2{
        void setName(String name);
    }

}


class Howdy  extends  ClassInterface.Test implements ClassInterface.ClassInterface2{
    public Howdy(String name) {
        super(name);
    }

    public void howdy() {
        System.out.println("Tests.howdy");
    }

    public void setName(String name) {

    }

    public static class TestMail{
        public static void main(String[] args) {
            new Howdy("shu").howdy();
            System.out.println(new Howdy("shu2").getName());
        }
    }
}


interface ThirthInterface{
    String getName();
}