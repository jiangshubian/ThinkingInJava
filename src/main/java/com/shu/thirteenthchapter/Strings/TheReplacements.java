package com.shu.thirteenthchapter.Strings;

import net.mindview.util.TextFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.xml.internal.bind.v2.util.ClassLoaderRetriever.getClassLoader;
import static java.util.regex.Pattern.MULTILINE;
import static java.util.regex.Pattern.compile;
import static net.mindview.util.BinaryFile.read;

/**
 * Created by Administrator on 2017-06-11.
 */
public class TheReplacements {
    /*! Here's a block of text to use as input to
            the regular expression matcher. Note that we'll
            first extract  the block of text by looking for
            the special delimiters, then process the
            extracted block. !*/

    public static void main(String[] args) throws IOException {
        String context = TextFile.read("src\\main\\java\\com\\shu\\thirteenthchapter\\Strings\\TheReplacements.java");
        Matcher matcher = compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(context);
        while (matcher.find()) {
            context = matcher.group();
        }
        System.out.println(context);//reginal
        context = context.replaceAll(" {2,}", " ");//replace two or more spaces with a single spaces
        System.out.println("replace two or more spaces with a single spaces:" + context);
//        replace tow or more spaces at the beginning of each line with no spaces. Must enable MULTILINE mode.
        context = context.replaceAll("(?m)^ +", "");//每一行
        System.out.println("replace tow or more spaces:" + context);
        context = context.replaceFirst("[aeiou]", "(VOWEL1)");
        System.out.println("replaceFirst:" + context);
        StringBuffer sbuf = new StringBuffer(context.length());
        Matcher matcher1 = Pattern.compile("[aeiou]").matcher(context);
        //Process the find information as you perform the replacements.
        while (matcher1.find()) {
            matcher1.appendReplacement(sbuf, matcher1.group().toUpperCase());
        }
        matcher1.appendTail(sbuf);//Put the remainder of the text.
        System.out.println("ret:\n"+sbuf.toString());//result replacements
        System.out.println();

        //2 group()
        String regex = "(x)(y\\w*)(z)";
//        String regex = "xy\\w*z";//No group

        String input = "exy123z,xy456z";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.print(m.group(i) + " ");
            }
        }
    }
}