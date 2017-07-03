package com.shu.fourteenthchapter.typeinfo;

import com.shu.fourteenthchapter.typeinfo.pets.*;

import java.util.HashMap;

import static net.mindview.util.Print.printnb;

/**
 * Created by Administrator on 2017-06-18.
 */
public class PetCount {
    private static class PetCounter extends HashMap<String, Integer> {
        public void count(String name) {
            Integer val = get(name);
            if (val != null) {
                put(name, val + 1);
            } else {
                put(name, 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();

        for (Pet pet : creator.createArray(20)) {
            // List each individual pet:
            printnb(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet)
                counter.count("Pet");
            if (pet instanceof Dog)
                counter.count("Dog");
            if (pet instanceof Mutt)
                counter.count("Mutt");
            if (pet instanceof Pug)
                counter.count("Pug");
            if (pet instanceof Cat)
                counter.count("Cat");
            if (pet instanceof Manx)
                counter.count("EgyptianMau");
            if (pet instanceof Manx)
                counter.count("Manx");
            if (pet instanceof Manx)
                counter.count("Cymric");
            if (pet instanceof Rodent)
                counter.count("Rodent");
            if (pet instanceof Rat)
                counter.count("Rat");
            if (pet instanceof Mouse)
                counter.count("Mouse");
            if (pet instanceof Hamster)
                counter.count("Hamster");
        }
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}/*
    Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Rat=2, Cymric=7, Cat=9, Pet=20, Dog=6, Manx=7, EgyptianMau=7, Pug=3, Mouse=2, Rodent=5, Hamster=1, Mutt=3}
    *///:~