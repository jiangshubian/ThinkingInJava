package com.shu.fourteenthchapter.typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 动物抽象类
 * Created by Administrator on 2017-06-18.
 */
public abstract class PetCreator {
    protected Random random = new Random(47);

    protected abstract List<Class<? extends Pet>> types();

    public Pet randomPet() { //Create one random Pet
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < pets.length; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public List<Pet> arrayList(int size) {
        List<Pet> list = new ArrayList<Pet>();
        Collections.addAll(list, createArray(size));
        return list;
    }
}
