package com.shu.eleventhchapter.hoding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Queue 队列 典型的先进先出的容器。。。
 * Created by Administrator on 2017-06-03.
 */
public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() != null)// if queue null then return null
//            System.out.print(queue.remove() + " "); // if queue null then throw NoSuchElementException
            System.out.print(queue.poll() + " "); // if queue null then return null
        System.out.println();
    }

    private static class Main {
        public static void main(String[] args) {
            //add to the int type
            Queue<Integer> queue = new LinkedList<Integer>();
            Random random = new Random(47);
            for (int i = 0; i < 10; i++)
                queue.offer(random.nextInt(i + 10));
            printQ(queue);

            //add to the char type
            Queue<Character> ch = new LinkedList<Character>();
            for (char c : "HandsomeBoys".toCharArray())
                ch.offer(c);
            printQ(ch);
        }
    }
}/*
8 1 1 1 5 14 3 1 0 1
H a n d s o m e B o y s
// *///~
