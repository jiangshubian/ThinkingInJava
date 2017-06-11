package com.shu.thirteenthchapter.Strings;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.xml.internal.bind.v2.util.ClassLoaderRetriever.getClassLoader;
import static java.util.regex.Pattern.MULTILINE;

/**
 * Created by Administrator on 2017-06-11.
 */
public class TheReplacements {
    /*! Here's a block of text to use as input to " +
            "the regular expression matcher. Note that we'll " +
            "first extract  the block of text by looking for " +
            "the special delimiters, then process the " +
            "extracted block. !*/

    public static void main(String[] args) throws IOException {
//        String context = CONTENT.replaceAll(" {2,}", " ");//replace two or more spaces with a single spaces
//        System.out.println(context);
//        replace tow or more spaces at the beginning of each line with no spaces. Must enable MULTILINE mode.
//        context = CONTENT.replaceAll("(?m)^ +", "");//每一行


        //2
        String regex = "(x)(y\\w*)(z)";
//        String regex = "xy\\w*z";//No group

        String input = "exy123z,xy456z";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);

        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        }
    }
}
