package com.shu.tenthchapter.innerclasses;

/**
 * 非静态内部类使用外围成员
 * Created by Administrator on 2017-05-20.
 */
public class Sequence {
    public Object[] items;
    private int next = 0;

    public Sequence(int initSize) {
        this.items = new Object[initSize];
    }

    public void add(Object obj) {
        if (next < items.length) items[next++] = obj;
    }

    //成员内部类
    private class SequenceSelector implements Selector {
        int curInd = 0;

        public boolean end() {
            return curInd == next;
        }

        public Object current() {
            return items[curInd];
        }

        public void next() {
            if (curInd < items.length) curInd++;
        }
    }

    private class ReverseSelector implements Selector {
        int curInd = items.length-1;

        public boolean end() {
            return curInd == -1;
        }

        public Object current() {
            return items[curInd];
        }

        public void next() {
            if (curInd >= 0) curInd--;
        }
    }

    public Selector sequenceSelector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < sequence.items.length; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector sequenceSelector = sequence.sequenceSelector(); //sequence.new SequenceSelector() 创建非静态内部类方式
        while (!sequenceSelector.end()) {
            System.out.println(sequenceSelector.current());
            sequenceSelector.next();
        }
        System.out.println("next is reverseSelector list:");
        Selector reverseSelector = sequence.reverseSelector(); //sequence.new ReverseSelector() 创建非静态内部类方式
        while (!reverseSelector.end()) {
            System.out.println(reverseSelector.current());
            reverseSelector.next();
        }
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}