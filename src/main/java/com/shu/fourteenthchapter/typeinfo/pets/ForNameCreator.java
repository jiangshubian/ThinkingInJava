package com.shu.fourteenthchapter.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-06-18.
 */
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    //Types that you want to random created:
    private static String[] typeNames = {
            "typeinfo.pets.Mutt",
            "typeinfo.pets.Pug",
            "typeinfo.pets.EgyptianMau",
            "typeinfo.pets.Manx",
            "typeinfo.pets.Cymric",
            "typeinfo.pets.Rat",
            "typeinfo.pets.Mouse",
            "typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader(){
        for (String name : typeNames){
            try {
                types.add((Class<? extends Pet>) Class.forName(name));
            } catch (ClassNotFoundException e) {
               new RuntimeException(e);
            }
        }
    }
    static {
        loader();
    }

    protected List<Class<? extends Pet>> types() {
        return types;
    }
}///:~
