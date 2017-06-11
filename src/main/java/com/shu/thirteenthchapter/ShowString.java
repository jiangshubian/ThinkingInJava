package com.shu.thirteenthchapter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * .$|()[{^?*+\ 需要使用转义方式才能使用split方法
 * Pattern.compile("\\\\").split("sj.$|()[{^?*+\\jd|diie|djjsnn|wwww"))
 * new String("sj.$|()[{^?*+\\jd|diie|djjsnn|wwww").split("\\|"))
 * Created by Administrator on 2017-06-07.
 */
public class ShowString {
    private static class Main {
        public static void main(String[] args) {
            String a = "abcshu";
            System.out.println("bcshud".regionMatches(true, 0, a, 1, 6));
            System.out.println(a.intern());

            String[] p0 = Pattern.compile(":").split("boo:and:foo");
            System.out.println(Arrays.toString(p0));
            String[] p = Pattern.compile(":").split("boo:and:foo", 2);
            System.out.println(Arrays.toString(p));
            String[] p2 = Pattern.compile(":").split("boo:and:foo", 5);
            System.out.println(Arrays.toString(p2));
            String[] p3 = Pattern.compile(":").split("boo:and:foo", -2);
            System.out.println(Arrays.toString(p3));

            String[] p4 = Pattern.compile("o").split("boo:and:foo", 0);
            System.out.println(Arrays.toString(p4));
            String[] p5 = Pattern.compile("o").split("boo:and:foo", 4);
            System.out.println(Arrays.toString(p5));
            String[] p6 = Pattern.compile("o").split("boo:and:foo", -4);
            System.out.println(Arrays.toString(p6));
            String[] p7 = Pattern.compile("o").split("boo:and:foo", 2);
            System.out.println(Arrays.toString(p7));

            //new Pattern().split()和new String(one).split(regexp)
            Pattern pattern = Pattern.compile("\\\\");
            System.out.println(Arrays.toString(pattern.split("sj.$|()[{^?*+\\jd|diie|djjsnn|wwww")));
            System.out.println(Arrays.toString(new String("sj.$|()[{^?*+\\jd|diie|djjsnn|wwww").split("\\|")));

            //Matcher appendReplacement()
            Matcher m = Pattern.compile("cat").matcher("one cat two cats in the yard");
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                System.out.println(m.group());
                m.appendReplacement(sb, m.group().toUpperCase());
                System.out.println("content stringbuffer:" + sb.toString());
            }
            m.appendTail(sb);
            System.out.println("appendReplacement ret:" + sb.toString());
        }
    }
}/*Output:
    false
    abcshu
    [boo, and, foo]
    [boo, and:foo]
    [boo, and, foo]
    [boo, and, foo]
    [b, , :and:f]
    [b, , :and:f, o]
    [b, , :and:f, , ]
    [b, o:and:foo]
    [sj.$|()[{^?*+, jd|diie|djjsnn|wwww]
    [sj.$, ()[{^?*+\jd, diie, djjsnn, wwww]
    cat
    content:one CAT
    cat
    content:one CAT two CAT
    appendReplacement ret:one CAT two CATs in the yard
*///~