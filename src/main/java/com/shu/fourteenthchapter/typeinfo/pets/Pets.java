package com.shu.fourteenthchapter.typeinfo.pets;

import java.util.List;

/**
 * LiteralPetCountor外观
 * Created by Administrator on 2017-06-18.
 */
public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createPet(int size) {
        return creator.createArray(size);
    }

    public static List<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
