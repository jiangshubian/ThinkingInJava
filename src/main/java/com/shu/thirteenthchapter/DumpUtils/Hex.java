package com.shu.thirteenthchapter.DumpUtils;

/**
 *
 * Created by Administrator on 2017-06-07.
 */
public class Hex {
    public static String format(byte[] data) {
        StringBuilder sb = new StringBuilder(data.length);
        int index = 0;
        for (byte d : data) {
            if (index % 16 == 0){
                sb.append(String.format("%05x: ", index));//16 --> 00010000(二进制) ->10(16进制)
            }
            sb.append(String.format("%02x ",d));
            index++;
            if (index % 16 == 0) sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(format("shjshjsjsjahdkshjshjsjsjahdkjdhakjsdasjdshjshjsjsjahdkjdhakjsdashakjsdas".getBytes()));
    }
}
