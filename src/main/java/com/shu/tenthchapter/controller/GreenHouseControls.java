package com.shu.tenthchapter.controller;

import java.util.List;

/**
 * This produces a specific application of the
 * control system, all in a single class. Inner classes allow you to encapsulate different
 * functionality for each type of event.
 * Created by Administrator on 2017-05-21.
 */
public class GreenHouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event{
        public LightOn(long delayTime) {
            super(delayTime);
        }
        //turn on the light
        public void action() {
            light=true;
        }

        public String toString(){
            return "Light is on.";
        }
    }
    public class LightOff extends Event{
        public LightOff(long delayTime) {
            super(delayTime);
        }
        //turn on the light
        public void action() {
            light=false;
        }

        public String toString(){
            return "Light is off.";
        }
    }

    public class Bell extends Event{

        public Bell(long delayTime) {
            super(delayTime);
        }
        //try again
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bell{}";
        }
    }

    public class RestartSystem extends Event{
        private Event[] eventList;
        public RestartSystem(long delayTime,Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList) addEvent(e);
        }

        public void action() {
            for (Event e : eventList){
                e.start(); //Rerun each event
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "RestartSystem{" +
                    "eventList=" + eventList +
                    '}';
        }
    }

    public class Terminate extends Event{

        public Terminate(long delayTime) {
            super(delayTime);
        }

        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminate exit.";
        }
    }
}
