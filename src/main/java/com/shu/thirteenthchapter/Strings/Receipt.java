package com.shu.thirteenthchapter.Strings;

import java.util.Formatter;

/**
 * Created by Administrator on 2017-06-07.
 * %[argument_index$][flags][width][.precision][t]conversion
 */
public class Receipt {
    private double total = 0D;
    private static final int WIDTH = 8;
    private static final char FLAGS = '-';

    private Formatter f = new Formatter(System.out);

    public void printTitle() {
        f.format("%" + FLAGS + WIDTH + "s %5s %10s\n", "Item", "Qty", "Price"); //%- 表示左对齐 默认为右对齐方式
        f.format("%" + FLAGS + WIDTH + "s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%" + FLAGS + WIDTH + "s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%" + FLAGS + WIDTH + "s %5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%" + FLAGS + WIDTH + "s %5s %10s\n", "", "", "-----");
        f.format("%" + FLAGS + WIDTH + "s %5s %10.2f\n", "Total", "", total * 1.06);
    }

    private static class Main {
        public static void main(String[] args) {
            Receipt r = new Receipt();
            r.printTitle();
            r.print("pig", 10, 2.333D);
            r.print("pig pii", 120, 3.333D);
            r.printTotal();
        }
    }

}
