
package com.shu.Fifteenthchapter.generic;

/**
 * Created by Administrator on 2017-07-22.
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(new Foo2<Integer>(new IntegerFactory()).getX());
        System.out.println(new Foo2<Weight>(new Weight.Factory()).getX());
    }
}

interface FactoryI<T>{
    T create();
}

class Foo2<T>{
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        this.x = factory.create();
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }
    //...
}

class IntegerFactory implements FactoryI<Integer>{

    public Integer create() {
        return new Integer(0);
    }
}

class Weight {
    public static class Factory implements FactoryI<Weight>{

        public Weight create() {
            return new Weight();
        }
    }
}