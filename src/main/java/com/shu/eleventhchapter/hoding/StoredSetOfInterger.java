package com.shu.eleventhchapter.hoding;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSet and father SortedSet
 * Created by Administrator on 2017-06-03.
 */
public class StoredSetOfInterger {

    private static class Main {
        public static void main(String[] args) {
            Random random = new Random(47);
            SortedSet<Integer> set = new TreeSet<Integer>();

            for (int i = 0; i < 10000; i++) {
                set.add(random.nextInt(30));
            }

            System.out.println(set.toString());


            for (int i = 33; i < 128; i++) { //see the ASICE code //~2^7
                System.out.print(i + "-" + (char) i + " ");
            }
        }
    }
}
