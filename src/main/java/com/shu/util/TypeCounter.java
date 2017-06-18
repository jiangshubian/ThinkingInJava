package com.shu.util;

import com.shu.fourteenthchapter.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-06-18.
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
        Class<?> type = object.getClass();

        if (!baseType.isAssignableFrom(type))
            throw new RuntimeException(object +
                    " incorrent type: " +
                    type +
                    ", should be type or subtype of " + baseType);
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> supperClass = type.getSuperclass();
        if (supperClass != null && baseType.isAssignableFrom(supperClass))
            countClass(supperClass);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            sb.append(pair.getKey().getSimpleName());
            sb.append("=");
            sb.append(pair.getValue());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }
}
