package com.shu.eleventhchapter.hoding;

import java.util.Map;
import java.util.Set;

import static java.lang.System.getenv;

/**
 * Iterable类型不对Map生效
 * Map.Entry map.entrySet() Entry包含了key和value
 * Set map.keySet() key
 * Collection map.values() value集合
 * Created by Administrator on 2017-06-04.
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        Set<Map.Entry<String,String>> entry = System.getenv().entrySet();
        for (Map.Entry<String,String> s : entry) {
            System.out.println(s.getKey()+"-"+s.getValue());
        }
    }
}
