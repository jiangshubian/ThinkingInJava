package com.shu.Fifteenthchapter.generic;

/**
 * 自定义实现内部链式存储机制
 * Created by Administrator on 2017-07-16.
 */
public class LinkedStack<U> {

    private static class Node<T> {
        /**
         * 泛型类型属性
         */
        private T item;
        /**
         * 下一个对象引用
         */
        private Node<T> next;

        /**
         * 通过构造器构造一个空对象
         */
        public Node() {
            this.item = null;
            this.next = null;
        }

        /**
         * 构造非空对象
         *
         * @param item
         * @param next
         */
        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * 是否为空对象
         * @return
         */
        public boolean end() {
            return item == null && next == null;
        }
    }

    private Node<U> top = new Node<U>();//末端哨兵(end sentinel)

    /**
     * 入栈
     * @param item 泛型类型形参
     */
    public void push(U item){
        top = new Node<U>(item,top);
    }


    /**
     * 出栈
     * @return
     */
    public U pop(){
        U item = top.item;
        if(!top.end()) top = top.next;
        return item;
    }


    private static class Test{
        public static void main(String[] args) {
            LinkedStack<String> ls = new LinkedStack<String>();
            for(String single : "This is a bad weather".split(" ")){
                ls.push(single);
            }
            String s;
            while((s=ls.pop()) != null) System.out.println(s);
        }
    }
}/*Out
weather
bad
a
is
This
*///~
