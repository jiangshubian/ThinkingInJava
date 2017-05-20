package com.shu.fifthchapter;

/**
 * Created by Administrator on 2017-04-11.
 */
public class ChangeableParams {

    public static void main(String[] args) {
        String[] arr = {"first","secode","firth"};
        stringChangeableParams(arr);
        System.out.println();
        stringChangeableParams(new String[]{"1","2"});
    }

    protected static void stringChangeableParams(String... arrs) {
        for (String arr : arrs) {
            System.out.print("arr:" + arr + " ");
        }
    }
}
