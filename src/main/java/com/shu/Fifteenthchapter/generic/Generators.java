package com.shu.Fifteenthchapter.generic;

import com.shu.Fifteenthchapter.generic.coffee.Coffee;
import com.shu.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * A utility to use with Generators.
 * Created by Administrator on 2017-07-17.
 */
public class Generators {

    public static <E> Collection<E> fill(Collection<E> coll, Generator<E> gen, int count) {
        for (int i = 0; i < count; ++i) coll.add(gen.next());
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees) System.out.print(coffee + " ");
        System.out.println();

        Collection<Integer> fobonaccis = fill(new ArrayList<Integer>(), new Fobonacci(), 18);
        for (Integer fobonacci : fobonaccis) System.out.print(fobonacci + " ");
        System.out.println();

        Collection<Integer> fobonaccis2 = fill(new HashSet<Integer>(), new Fobonacci(), 18);
        for (Integer fobonacci : fobonaccis2) System.out.print(fobonacci + " ");
    }

}
