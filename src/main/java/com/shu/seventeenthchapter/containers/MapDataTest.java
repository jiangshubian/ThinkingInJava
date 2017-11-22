package com.shu.seventeenthchapter.containers;

import com.shu.util.*;

import java.util.Iterator;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-08-28 13:59
 * @Version: 1.0.0
 */

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';


    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }

    public Iterator<Integer> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Integer> {

        public boolean hasNext() {
            return number < size;
        }

        public Integer next() {
            return number++;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}

public class MapDataTest {
    private static class TestMain {
        public static void main(String[] args) {
            //Pair Generator
            System.out.println(MapData.map(new Letters(), 11));

            //Two separate generators
            System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));

            //A key Generator and a single value
            System.out.println(MapData.map(new CountingGenerator.Character(), "value", 10));

            //An Iterable and a value Generator
            System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));


            //An Iterable and a single value
            System.out.println(MapData.map(new Letters(), "pop"));

        }
    }
}
