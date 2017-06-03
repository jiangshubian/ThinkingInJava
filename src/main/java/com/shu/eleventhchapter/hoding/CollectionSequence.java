package com.shu.eleventhchapter.hoding;

import com.shu.eleventhchapter.utils.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Created by Administrator on 2017-06-03.
 */
public class CollectionSequence extends AbstractCollection<Pets> {
    private Pets[] pets = Pets.createArray(3);

    public Iterator<Pets> iterator() {
        return new Iterator<Pets>() {
            private int index = 0;

            public boolean hasNext() {
                return index < pets.length;
            }

            public Pets next() {
                return pets[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size() {
        return pets.length;
    }

    private static class Main {
        public static void main(String[] args) {
            CollectionSequence collectionSequence = new CollectionSequence();
            InterfaceVsIterator.display(collectionSequence);
            InterfaceVsIterator.display(collectionSequence.iterator());

        }
    }
}/*
0:Pets{id=0, name='0'} 1:Pets{id=1, name='1'} 2:Pets{id=2, name='2'}
0:Pets{id=0, name='0'} 1:Pets{id=1, name='1'} 2:Pets{id=2, name='2'}
*///~
