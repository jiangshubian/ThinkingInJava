package com.shu.fourteenthchapter.typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字面量常量
 * Created by Administrator on 2017-06-18.
 */
public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                    Cymric.class, Rat.class, Mouse.class, Hamster.class));
    // Types for random creation:
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class),
                    allTypes.size());

    protected List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}/*
[class com.shu.fourteenthchapter.typeinfo.pets.Mutt, class com.shu.fourteenthchapter.typeinfo.pets.Pug, class com.shu.fourteenthchapter.typeinfo.pets.EgyptianMau, class com.shu.fourteenthchapter.typeinfo.pets.Manx, class com.shu.fourteenthchapter.typeinfo.pets.Cymric, class com.shu.fourteenthchapter.typeinfo.pets.Rat, class com.shu.fourteenthchapter.typeinfo.pets.Mouse, class com.shu.fourteenthchapter.typeinfo.pets.Hamster]
*///:~