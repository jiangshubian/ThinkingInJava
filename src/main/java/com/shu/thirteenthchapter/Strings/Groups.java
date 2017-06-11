package com.shu.thirteenthchapter.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组正则方法使用
 * 分组0为全匹配的结果 group()-等价于->group(0)
 * 其他逐个分组由1开始,groupCount()结束
 * <p>
 * Created by Administrator on 2017-06-10.
 */
public class Groups {
    private static final String POEM = "Twas briling, and the slithy toves\n" +
            "Did gyre abd gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the more raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, and shun\n" +
            "The frumious Beandersnatch.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s((\\S+)\\s(\\S+))$").matcher(POEM);
        while (m.find()) {
            for (int i = 0; i < m.groupCount(); i++)
                System.out.print("[index" + i + ";" + m.group(i) + "-start:" + m.start(i) + "-end:" + m.end(i) + "] ");
            System.out.println();
        }
        Matcher m2 = Pattern.compile("\\b").matcher(POEM);
        while (m2.matches()) {
            for (int i = 1; i < m.groupCount(); i++)
                System.out.print("[index" + i + ";" + m2.group(i)+ "] ");
            System.out.println();
        }


        Pattern datePatt = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
        Matcher mData = datePatt.matcher("02/10/2019");
        if (mData.matches()) {
            System.out.println(mData.group(0));//与下面结果相同
            System.out.println(mData.group());
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= mData.groupCount(); i++) {//1....groupCount()
                sb.append(mData.group(i));
                sb.append("-");
            }
            System.out.println(sb.toString());
        }
    }
}
