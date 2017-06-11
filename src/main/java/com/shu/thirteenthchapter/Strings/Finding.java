package com.shu.thirteenthchapter.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher的find()和find(int)方法
 * Created by Administrator on 2017-06-08.
 */
public class Finding {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\w+").matcher("Eventing is full of the linnet's wings");
        while(matcher.find()){
            System.out.print(matcher.group()+" ");
        }
        System.out.println();
        int index=0;
        while (matcher.find(index)){
            System.out.print(matcher.group()+" ");
            index++;
        }
    }
}/*
Eventing is full of the linnet s wings
Eventing venting enting nting ting ing ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet net et t s s wings wings ings ngs gs s
*///~
