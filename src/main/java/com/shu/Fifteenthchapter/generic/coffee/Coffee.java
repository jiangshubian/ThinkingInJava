package com.shu.Fifteenthchapter.generic.coffee;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-07-16 21:31
 * @Version: 1.0.0
 */
public class Coffee {
    private static long count = 0;
    private final long id = count++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                '}';
    }
}
