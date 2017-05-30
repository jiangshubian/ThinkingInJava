package com.shu.eleventhchapter.hoding;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Adding groups of elements to Collection objects.
 * Created by Administrator on 2017-05-29.
 */
public class AddingGroups {
    private static class Main {
        public static void main(String[] args) {
            Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
            Integer[] moreInt = {7, 8, 9, 10};
            collection.addAll(Arrays.asList(moreInt));
            System.out.println(collection);

            //Run significantly faster, but you can't construct a Collection a way.s
            Collections.addAll(collection, 12, 13, 14);
            Collections.addAll(collection, moreInt);
            System.out.println(collection);

            //Produces a list "backed by" an array:
            List<Integer> list = Arrays.asList(15, 16, 17, 18);
            list.set(1, 19); //Modify an element
//            list.add(20); //Runtiem eroor because the underlying array can't be resied.
            //Exception in thread "main" java.lang.UnsupportedOperationException
            System.out.println(list);
        }
    }


    /**
     * 测试
     * 1、 Collections.addALL(Collection<T> a,Object.... b);
     * 2、collection.addAll(Collection<T> a)
     * 1千万a数据
     * 1耗时300ms 2耗时1s
     */
    private static class TestAddAllMethodPro {
        public static void main(String[] args) {
            Collection<Integer> collection = new ArrayList<Integer>();
            Integer[] obj = new Integer[8000000];
            for (int i = 0; i < obj.length; i++) {
                obj[i] = i;
            }
            long start = System.currentTimeMillis();

            collection.addAll(Arrays.asList(obj))
            ;
            System.out.println(System.currentTimeMillis() - start);

            Collection<Integer> collection2 = new ArrayList<Integer>();

            start = System.currentTimeMillis();
            Collections.addAll(collection2, obj);
            System.out.println("2:" + (System.currentTimeMillis() - start));

        }
    }

}
