package com.shu.twelfthchapter;

import java.util.Random;

/**
 * Created by Administrator on 2017-06-04.
 */
public class UsingStringBuilder {
    private static final Random random = new Random(47);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            sb.append(random.nextInt(100));
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
