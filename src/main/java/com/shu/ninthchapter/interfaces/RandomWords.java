package com.shu.ninthchapter.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * 策略设计模式例子：使用Scanner对象的构造方法使用接口Readable作为形参
 * Created by Administrator on 2017-05-20.
 */
public class RandomWords implements Readable {

    private static Random random = new Random(47);

    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();

    private int count;

    public RandomWords() {
    }

    public RandomWords(int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) throws IOException {
//        System.out.println("count:" + count);
        if(count-- == 0) return -1; //Indicates end of input
        cb.append(capitals[random.nextInt(capitals.length)]); //Before word
        for(int i=4;i>0;i--){
            cb.append(lowers[random.nextInt(lowers.length)]);
            cb.append(vowels[random.nextInt(vowels.length)]);
        }
        cb.append(" ");
        return 10;//The number of char values added to the buffer, or -1 if this source of characters is at its end
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(new RandomWords(10));
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }/*Outout
    Ynobenogi
    Foozutoqe
    Gsegemuje
    Roisueeue
    Neueolome
    Hlieehoca
    Reeuebiki
    Naieobuwa
    Kjirokope
    Wsupodoco
    *///:~
}
