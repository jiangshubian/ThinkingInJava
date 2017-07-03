package com.shu.fourteenthchapter.typeinfo;

import com.shu.fourteenthchapter.typeinfo.pets.LiteralPetCreator;
import com.shu.fourteenthchapter.typeinfo.pets.Pet;
import com.shu.fourteenthchapter.typeinfo.pets.Pets;
import net.mindview.util.MapData;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 动态的isInstance()替换instanceof
 * Created by Administrator on 2017-06-18.
 */
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0)); //初始化PetCounter对象数据，value为0
        }

        public void count(Pet pet) {
            //Class.isInstance() eliminates instanceofs.
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet())
                if (pair.getKey().isInstance(pet)) put(pair.getKey(), pair.getValue() + 1);

        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                sb.append(pair.getKey().getSimpleName());
                sb.append("=");
                sb.append(pair.getValue());
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("}");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet : Pets.createPet(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            petCounter.count(pet);
        }
        System.out.println();
        System.out.println(petCounter);
    }
}/*
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pet=20, Dog=6, Cat=9, Rodent=5, Mutt=3, Pug=3, EgyptianMau=2, Manx=7, Cymric=5, Rat=2, Mouse=2, Hamster=1}
*///:~
