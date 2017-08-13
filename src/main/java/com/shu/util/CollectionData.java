package com.shu.util;

import java.util.ArrayList;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-08-14 0:02
 * @Version: 1.0.0
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}
