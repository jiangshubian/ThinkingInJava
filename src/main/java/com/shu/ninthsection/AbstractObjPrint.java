package com.shu.ninthsection;

/**
 * Created by Administrator on 2017-05-04.
 */
public class AbstractObjPrint extends AbstractObj {
    private int i = 10;

    public AbstractObjPrint() {
        this.print();
    }

    protected void print() {
        System.out.println("i:"+i);
    }
}
