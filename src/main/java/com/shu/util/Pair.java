package com.shu.util;

/**
 * @author: jiangshubian
 * @Description: 只读的数据传输对象
 * @Date: Create in 2017-08-28 11:22
 * @Version: 1.0.0
 */
public class Pair<K,V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
