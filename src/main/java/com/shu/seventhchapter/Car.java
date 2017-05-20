package com.shu.seventhchapter;

/**
 * resing/Car.java
 * Composition with public objects,in order to show easy to programmer;usually with private.
 * Created by Administrator on 2017-04-25.
 */
public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4]; //the car of wheel
    public Door left = new Door(),right = new Door(); //left door and right door

    public Car() {
        for(int i=wheel.length-1;i>=0;i--){
            wheel[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        car.engine.service();
    }
}

class Engine{
    public void start(){}
    public void stop(){}
    public void reverse(){}
    public void service(){
        System.out.println("Engine.service");
    }
}

class Wheel{
    public void inflate(int psi){
        System.out.println("Wheel.inflate:"+psi);
    }
}

class  Window{
    public void rollup(){
        System.out.println("Window.rollup");
    }
    public void rolldown(){
        System.out.println("Window.rolldown");
    }
}

class Door{
    public Window window = new Window();
    public void open(){
        System.out.println("Door.open");
    }
    public void close(){
        System.out.println("Door.close");
    }
}