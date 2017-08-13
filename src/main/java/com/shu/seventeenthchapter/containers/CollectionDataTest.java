package com.shu.seventeenthchapter.containers;

import com.shu.util.CollectionData;
import com.shu.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-08-13 23:59
 * @Version: 1.0.0
 */
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(new CollectionData(new Goverment(), Goverment.foundation.length));
        set.addAll(CollectionData.list(new Goverment(), Goverment.foundation.length));
        System.out.println(set);
    }
}

class Goverment implements Generator<String> {
    public static String[] foundation = ("strange women lying in ponds distributing swords is no basis for a system of goverment").split(" ");
    private int index;

    public String next() {
        return foundation[index++];
    }
}