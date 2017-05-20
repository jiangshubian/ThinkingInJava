package com.shu.eighthchapter;

import java.util.Random;

/**
 * 图形基类,说明后期动态绑定
 * Created by 123 on 2017/5/2.
 */
public abstract class Shape {
    public abstract void draw();//写方法

    public abstract void erase();//涂改方法
}

/**
 * polymorphism/shape/Circle.java
 */
class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle.draw");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase");
    }
}

/**
 * polymorphism/shape/Square.java
 */
class Square extends Shape {

    @Override
    public void draw() {
        System.out.println("Sqare.draw");
    }

    @Override
    public void erase() {
        System.out.println("Sqare.erase");
    }
}

/**
 * polymorphism/shape/Triangle.java
 */
class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Triangle.draw");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase");
    }
}

/**
 * polymorphism/shape/RandomShapeGenerator.java
 * A "factory" that randomly creates shape
 */
class RandomshapeGenerator {
    private Random random = new Random(47);

    public Shape next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}

/**
 * polymorphism/Shapes.java
 * polymorphism in java
 */
class Shapes {
    private static RandomshapeGenerator randomshapeGenerator = new RandomshapeGenerator();
    private Shape shape;

    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        //Fill up the array with shapes
        for (int i = 0; i < s.length; i++) {
            s[i] = randomshapeGenerator.next();
        }

        //Make polymorphism method calls
        for (Shape single : s) single.draw();
    }
}/*Output:
    Triangle.draw
    Triangle.draw
    Sqare.draw
    Triangle.draw
    Sqare.draw
    Triangle.draw
    Sqare.draw
    Triangle.draw
    Circle.draw
*/