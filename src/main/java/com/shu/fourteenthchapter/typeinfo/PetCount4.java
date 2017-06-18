package com.shu.fourteenthchapter.typeinfo;

import com.shu.fourteenthchapter.typeinfo.pets.Pet;
import com.shu.fourteenthchapter.typeinfo.pets.Pets;
import com.shu.util.TypeCounter;

/**
 * Created by Administrator on 2017-06-18.
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createPet(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            typeCounter.count(pet);
        }
        System.out.println();
        System.out.println(typeCounter);
    }
}/*
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pug=3, Rat=2, EgyptianMau=2, Mouse=2, Pet=20, Manx=7, Mutt=3, Cymric=5, Dog=6, Cat=9, Hamster=1, Rodent=5}
*///:~
