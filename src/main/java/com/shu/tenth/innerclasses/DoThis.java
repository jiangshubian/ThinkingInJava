package com.shu.tenth.innerclasses;

/**
 * 非静态内部类使用外部类方式(外部类.this)
 * Created by Administrator on 2017-05-20.
 */
public class DoThis {
    int i = 10;
    int y = 10;

    void f() {
        System.out.println("DoThis.f");
    }

    class InnerClass {
        int i = 20;
        public DoThis outObj() {
            System.out.println(i*y+"--"+DoThis.this.i);
            return DoThis.this;
        }
    }

    public InnerClass getIC() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        DoThis d = new DoThis();
        InnerClass i = d.getIC();
        i.outObj().f();
    }
}
