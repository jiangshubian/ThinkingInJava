package com.shu.eleventhchapter.utils;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 2017-05-30.
 */
public class ListIteration {

    private static class Main {
        public static void main(String[] args) {
            List<Pets> pets = Pets.arrayList(10);
            ListIterator<Pets> listIterator = pets.listIterator();

            while (listIterator.hasNext()) {
                System.out.print(listIterator.next() + "," + listIterator.nextIndex() + "\t" + listIterator.previousIndex() + "\t");
            }
            System.out.println();


            //Backwards:
            while (listIterator.hasPrevious()) {
                System.out.print(listIterator.previous().getId() + " ");
//                listIterator.remove();
            }
            System.out.println();
            System.out.println(pets); //Show roginal list
            if (pets.size() > 3) {
                listIterator = pets.listIterator(3);
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.set(Pets.randomPet());
                }
                System.out.println(pets);
            }
        }
    }

}
