package com.shu.eleventhchapter.hoding;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Administrator on 2017-06-03.
 */
public class UniqueWords {

    private static class Main {
        public static void main(String[] args) {
            Set<String> words = new TreeSet<String>(Arrays.asList("A","B","a","aaa","AA","abc","aaa","Abc"));
            System.out.println(words);

            words = new TreeSet<String>(UniqueWords.caseInsensitiveComparatorAnonymentClass);
            words.addAll(Arrays.<String>asList("a","B","A","aaa","AA","abc","aaa","Abc"));
//            for (String w : words)
            System.out.println(words);

        }
    }

    public static final Comparator<String> caseInsensitiveComparatorAnonymentClass = new SortCaseInsensitiveComparator();

    private static class SortCaseInsensitiveComparator implements Comparator<String>, Serializable {

        private static final long serialVersionUID = 3402892659150974846L;

        public int compare(String o1, String o2) {
            int n1 = o1.length();
            int n2 = o2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = o1.charAt(i);
                        char c2 = o2.charAt(i);
                if (c1 != c2) {
                    c1 = Character.toUpperCase(c1);
                    c2 = Character.toUpperCase(c2);
                    if (c1 != c2) {
                        c1 = Character.toLowerCase(c1);
                        c2 = Character.toLowerCase(c2);
                        if (c1 != c2) {
                            return c1 - c2;//will auto switch int type
                        }
                    }
                }
            }
            return n1 - n2;
        }
    }
}
