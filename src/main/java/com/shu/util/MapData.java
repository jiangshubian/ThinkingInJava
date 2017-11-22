package com.shu.util;

import java.util.LinkedHashMap;

/**
 * @author: jiangshubian
 * @Description: Map数据填充适配器
 * @Date: Create in 2017-08-28 11:34
 * @Version: 1.0.0
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    //A single Pair Generator
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> pair = gen.next();
            put(pair.key, pair.value);
        }
    }

    //Two separate Generator
    public MapData(Generator<K> key, Generator<V> value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(key.next(), value.next());
        }

    }

    //A key Generator and a single value
    public MapData(Generator<K> key, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(key.next(), value);
        }
    }


    //An Iterable and a value Generator
    public MapData(Iterable<K> genK, Generator<V> genV) {
        for (K k : genK) {
            put(k, genV.next());
        }
    }

    //An Iterable and a single value
    public MapData(Iterable<K> genK, V genV) {
        for (K k : genK) {
            put(k, genV);
        }
    }

    //Generic convenience methods
    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen,int quantity) {
        return new MapData<K, V>(gen, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> key, Generator<V> value, int quantity) {
        return new MapData<K, V>(key, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> key, V value, int quantity) {
        return new MapData<K, V>(key, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<K, V>(genK, genV);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, V genV) {
        return new MapData<K, V>(genK, genV);
    }

}
