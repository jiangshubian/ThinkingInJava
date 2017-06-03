package com.shu.eleventhchapter.hoding;

import com.shu.eleventhchapter.utils.Pets;

import java.util.*;

/**
 * 优先级队列 可以确保在调用peek(),poll()和remove()方法时，获取的元素将是队列中优先级最高的元素。
 * ……PriorityQueue对字符的优先级是根据ASIC码对应的顺序依次排序的……
 * Created by Administrator on 2017-06-03.
 */
public class PriorityQueueDemo {
    private static class Main {
        public static void main(String[] args) {

            //1.PriorityQueueu with the Integer type
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
            Random random = new Random(47);
            for (int i = 0; i < 10; i++)
                priorityQueue.offer(random.nextInt(i + 10));
            QueueDemo.printQ(priorityQueue);
//2.add list into the constructor parameter
            List<Integer> ist = Arrays.<Integer>asList(25, 22, 12, 43, 5, 2, 5, 2, 7, 58, 4, 21, 80, 6);
            priorityQueue = new PriorityQueue<Integer>(ist);
            QueueDemo.printQ(priorityQueue);

            //3. init PriorityQueue constructor
            // and set second parameter of constructor with Comparator from Conllections.reverseOrder() method
            priorityQueue = new PriorityQueue<Integer>(ist.size(), Collections.reverseOrder());
            priorityQueue.add(0);
            priorityQueue.addAll(ist);
            priorityQueue.add(1);
            QueueDemo.printQ(priorityQueue);


            //4. 空格优先级比字母还高
            String str = "Handsome Boys 123 >@#!($^@ ";
            List<String> strList = Arrays.asList(str.split(""));
            PriorityQueue<String> priorityQueueStr = new PriorityQueue<String>(strList);
            QueueDemo.printQ(priorityQueueStr);

            //5.
            priorityQueueStr = new PriorityQueue<String>(strList.size(), Collections.<String>reverseOrder());
            priorityQueueStr.addAll(strList);
            QueueDemo.printQ(priorityQueueStr);

            //6.remove similar elements
            Set<Character> ch = new HashSet<Character>();
            for (char c : str.toCharArray())
                ch.add(c);
            PriorityQueue<Character> priorityQueueChar = new PriorityQueue<Character>(ch);
            QueueDemo.printQ(priorityQueueChar);


            //7 Practice29
            //PriorityQueue<Pets> persons = new PriorityQueue<Pets>();//为指定对象类型比较类型，报错
            //Exception in thread "main" java.lang.ClassCastException:
            // com.shu.eleventhchapter.utils.Pets cannot be cast to java.lang.Comparable
            //需要指定对象类型比较规则，否则报错
            PriorityQueue<Pets> persons = new PriorityQueue<Pets>(10, new Comparator<Pets>() {
                public int compare(Pets o1, Pets o2) {
                    return o1.hashCode() - o2.hashCode();
                }
            });
            for (int i = 0; i < 10; i++)
                persons.add(Pets.randomPet());
            QueueDemo.printQ(persons);
        }
    }

}/* Output:
0 1 1 1 1 1 3 5 8 14
2 2 4 5 5 6 7 12 21 22 25 43 58 80
80 58 43 25 22 21 12 7 6 5 5 4 2 2 1 0
         ! # $ ( 1 2 3 > @ @ B H ^ a d e m n o o s s y
y s s o o n m e d a ^ H B @ @ > 3 2 1 ( $ # !
  ! # $ ( 1 2 3 > @ B H ^ a d e m n o s y
*///~
