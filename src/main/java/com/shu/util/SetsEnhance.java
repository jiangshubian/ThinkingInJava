package com.shu.util;

import java.util.*;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-07-21 16:17
 * @Version: 1.0.0
 */
public class SetsEnhance extends AbstractSet
        implements Cloneable, java.io.Serializable {
    private static final long serialVersionUID = -8574872065781095933L;

    /**
     * 并集
     *
     * @param a   set集合a
     * @param b   set集合b
     * @param <T> 泛型类型
     * @return 并集集合
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 交集
     *
     * @param a   set集合a
     * @param b   set集合b
     * @param <T> 泛型类型
     * @return 交集集合
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 差集集合
     *
     * @param a   set集合a
     * @param b   set集合b
     * @param <T> 泛型类型
     * @return 差集集合
     */
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.removeAll(b);
        return result;
    }

    /**
     * 除交集外的集合
     *
     * @param a   set集合a
     * @param b   set集合b
     * @param <T> 泛型类型
     * @return
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    public Iterator iterator() {
        return null;
    }

    public int size() {
        return 0;
    }

    /**
     * Returns a copy of this setsEnhance.
     *
     * @return a copy of this setsEnhance
     */
    public SetsEnhance clone() {
        try {
            return (SetsEnhance) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

