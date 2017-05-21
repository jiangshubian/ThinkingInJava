package com.shu.tenthchapter.innerclasses;

/**
 * 闭包
 * Created by Administrator on 2017-05-21.
 */
public class CallBacks {
    static class testMain{
        public static void main(String[] args) {
            Callee1 c1 = new Callee1();
            Callee2 c2 = new Callee2();
            MyIncrement.f(c2);

            Caller call1 = new Caller(c1);
            Caller call2 = new Caller(c2.getCallbackReference());
            call1.go();
            call1.go();
            call2.go();
            call2.go();
        }
    }
}

interface Incrementable {
    void increment();
}

//Very simple to just implement the interface.
class Callee1 implements Incrementable {
    private int i = 0;

    public void increment() {
        i++;
        System.out.println(i);
    }
}


/**
 * If you class must implement increment() in some other way,you must use aninner class.
 */
class Callee2 extends MyIncrement{
    private int i=0;
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable{

        public void increment() {
            //Specify outer-class method,otherwise you'd get an infinite recursion
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }


}

class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable i){
        callbackReference = i;
    }

    void go() {
        callbackReference.increment();
    }
}

class MyIncrement {
    public void increment(){
        System.out.println("MyIncrement.increment");
    }
    static void f(MyIncrement m){
        m.increment();
    }
}
/*Output:
    MyIncrement.increment
    1
    1
    2
    MyIncrement.increment
    2
    MyIncrement.increment
    3
* *///~