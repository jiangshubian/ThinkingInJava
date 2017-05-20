package com.shu.ninthchapter.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * Created by Administrator on 2017-05-20.
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {

    private int count;

    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0) return -1;
        String ret = Double.toString(next())+" ";
        cb.append(ret);
        return ret.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdaptedRandomDoubles(10));
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
