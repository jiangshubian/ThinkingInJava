package com.shu.eleventhchapter.hoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 适配器方法惯用法
 * Created by Administrator on 2017-06-0.
 */
public class AdapterMethodIdiom {
    public static class ReversibleArrayList<T> extends ArrayList<T> {
        public ReversibleArrayList(Collection<? extends T> c) {
            super(c);
        }

        public Iterable<T> reversed() {
            return new Iterable<T>() {

                public Iterator<T> iterator() {
                    return new Iterator<T>() {
                        int cur = size() - 1;

                        public boolean hasNext() {
                            return cur > -1;
                        }

                        public T next() {
                            return get(cur--);
                        }

                        public void remove() {
                            throw new UnsupportedOperationException();
                        }
                    };
                }
            };
        }
    }

    private static class Main {
        public static void main(String[] args) {
            ReversibleArrayList<String> stringReversibleArrayList =
                    new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
            //Grabs the ordinary iterator via iterator()
            for (String s : stringReversibleArrayList) {
                System.out.print(s+" ");
            }
            System.out.println();

            //Hand it the iterable of your choice
            for (String s : stringReversibleArrayList.reversed()) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}/*Output:
To be or not to be
be to not or be To
*///~
