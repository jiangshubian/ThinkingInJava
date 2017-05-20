package com.shu.seventhchapter;

/**
 * Created by Administrator on 2017-04-13.
 */
public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon.Cartoon");
    }

    public static void main(String[] args) {
        Cartoon c;
    }/*
        Art.Art
        Drawing.Drawing
        Cartoon.Cartoon
    */
}

class Art {
    public Art() {
        System.out.println("Art.Art");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing.Drawing");
    }
}