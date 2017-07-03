package com.shu.test;

import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017-07-02.
 */
public class RamdonTest {

    private static class randomGenerator{
        public static void main(String[] args) {
            TreeMap<Integer,Integer> redioNum = new TreeMap<Integer, Integer>();
            Random random = new Random();
            for(int i=0;i<100000;i++){
                int y = random.nextInt(10000);
                Integer val = redioNum.get(y);
                if(null != val){
                    redioNum.put(y, val + 1);
                } else {
                    redioNum.put(y, 0);
                }

            }
            System.out.println(redioNum);
        }
    }
}
