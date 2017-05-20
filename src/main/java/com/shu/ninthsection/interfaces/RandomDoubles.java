package com.shu.ninthsection.interfaces;

import java.util.Random;

/**
 * Created by Administrator on 2017-05-20.
 */
public class RandomDoubles {
    private static Random random = new Random(47);

    protected double next() {
        return random.nextDouble();
    }
    public static void main(String[] args) {
        RandomDoubles randomDoubles = new RandomDoubles();
        for(int i=7;i>0;i--){
            System.out.println(randomDoubles.next()+" ");
        }
    }

}
