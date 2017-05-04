package com.shu.ninthsection;

/**
 * Created by Administrator on 2017-05-04.
 */
public abstract class AbstractObj {
    public AbstractObj() {
        print();
    }
    private final int maxCount = 10;

    protected abstract void print();
}
