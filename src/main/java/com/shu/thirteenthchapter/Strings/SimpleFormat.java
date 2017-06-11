package com.shu.thirteenthchapter.Strings;

/**
 * Created by Administrator on 2017-06-07.
 */
public class SimpleFormat {
    private static class Main {
        public static void main(String[] args) {
            int x = 10;
            float y = 3.1415F;

            //The old way
            System.out.println("Row 1: [" + x + " " + y + "]");

            //The new way
            System.out.printf("Row 2: [%d %f]", x, y);
            System.out.println();
            //Or
            System.out.format("Row 2: [%d %f]", x, y);
            System.out.println();
            //Or
            System.out.println(String.format("Row 3: [%d %f]", x, y));
        }
    }
}
