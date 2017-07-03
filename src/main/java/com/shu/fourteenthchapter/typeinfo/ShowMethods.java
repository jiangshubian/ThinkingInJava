package com.shu.fourteenthchapter.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Using reflection to show all methods of a class, even if the methods are defined in the base class.
 * Created by Administrator on 2017-06-20.
 */
class ShowMethods {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";

//    private static Pattern pattern = Pattern.compile("\\w+\\."); //除去包路径
    private static Pattern pattern = Pattern.compile("((final|native)|(\\w+\\.))");//除去包路径或者修饰变量

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int line = 0;
        try {
            Class clazz = Class.forName(args[0]);
            Method[] methods =  clazz.getMethods();//clazz.getDeclaredMethods(); //Get all on this object only6y
            Constructor[] constructor = clazz.getConstructors();//clazz.getDeclaredConstructors(); //Get all on this object only
            if (args.length == 1) {
                for (Method m : methods) System.out.println(pattern.matcher(m.toString()).replaceAll(""));
                for (Constructor c : constructor) System.out.println(pattern.matcher(c.toString()).replaceAll(""));
                line = methods.length + constructor.length;
            } else {
                for (Method m : methods) {
                    if (m.toString().indexOf(args[1]) != -1) {
                        System.out.println(pattern.matcher(m.toString()).replaceAll(""));
                        line++;
                    }
                }
                for (Constructor c : constructor) {
                    if (c.toString().indexOf(args[1]) != -1) {
                        System.out.println(pattern.matcher(c.toString()).replaceAll(""));
                        line++;
                    }
                }
            }
            System.out.println("Line:" + line);
        } catch (Exception e) {
            System.out.println("No such class " + e);
        }
    }
    private void test(){}
}
