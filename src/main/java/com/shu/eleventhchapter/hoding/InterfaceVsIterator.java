package com.shu.eleventhchapter.hoding;

import com.shu.eleventhchapter.utils.Pets;

import java.util.*;

/**
 * Created by Administrator on 2017-06-03.
 */
public class InterfaceVsIterator {
    public static void display(Iterator<Pets> iterator) {
        while (iterator.hasNext()) {
            Pets p = iterator.next();
            System.out.print(p.getId() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Pets> collection) {
        for (Pets p : collection) {
            System.out.print(p.getId() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pets> petsList = Pets.arrayList(6);
        Set<Pets> petsSet = new HashSet<Pets>(petsList);
        Map<String, Pets> petsMap = new LinkedHashMap<String, Pets>();
        String[] name = "handsome boys and girl ".split(" ");
        for (int i = 0; i < name.length; i++) {
            petsMap.put(name[i], petsList.get(i));
        }

        //show diff result
        display(petsList);
        display(petsSet);
        display(petsList.iterator());
        display(petsSet.iterator());

        System.out.println(petsMap);
        System.out.println(petsMap.keySet());//Set
        display(petsMap.values());//Collection
        display(petsMap.values().iterator());
    }
}/*
0:Pets{id=0, name='0'} 1:Pets{id=1, name='1'} 2:Pets{id=2, name='2'} 3:Pets{id=3, name='3'} 4:Pets{id=4, name='4'} 5:Pets{id=5, name='5'}
0:Pets{id=0, name='0'} 1:Pets{id=1, name='1'} 2:Pets{id=2, name='2'} 3:Pets{id=3, name='3'} 4:Pets{id=4, name='4'} 5:Pets{id=5, name='5'}
0:Pets{id=0, name='0'} 1:Pets{id=1, name='1'} 2:Pets{id=2, name='2'} 3:Pets{id=3, name='3'} 4:Pets{id=4, name='4'} 5:Pets{id=5, name='5'}
0:Pets{id=0, name='0'} 1:Pets{id=1, name='1'} 2:Pets{id=2, name='2'} 3:Pets{id=3, name='3'} 4:Pets{id=4, name='4'} 5:Pets{id=5, name='5'}
{handsome=Pets{id=0, name='0'}, boys=Pets{id=1, name='1'}, and=Pets{id=2, name='2'}, girl=Pets{id=3, name='3'}}
[handsome, boys, and, girl]
0:Pets{id=0, name='0'} 1:Pets{id=1, name='1'} 2:Pets{id=2, name='2'} 3:Pets{id=3, name='3'}
0:Pets{id=0, name='0'} 1:Pets{id=1, name='1'} 2:Pets{id=2, name='2'} 3:Pets{id=3, name='3'}
*///~
