package com.shu.twentyfirstchapter.concurrency.shareResource;

/**
 *
 * 递增数字生产类（非任务对象）
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-12-03 20:30
 * @Version: 1.0.0
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    //Allow this to be canceled
    public boolean isCanceled(){
        return canceled;
    }

    public void cancel(){
        canceled = true;
    }
}
