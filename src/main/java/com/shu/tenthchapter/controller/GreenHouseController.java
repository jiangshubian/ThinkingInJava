package com.shu.tenthchapter.controller;

/**
 * Created by Administrator on 2017-05-21.
 */
public class GreenHouseController {

    public static class Test{
        public static void main(String[] args) {
            GreenHouseControls g = new GreenHouseControls();
            g.addEvent(g.new Bell(900));

            Event[] events = {
              g.new LightOn(400),
              g.new LightOff(600)
            };

            g.addEvent(g.new RestartSystem(2000,events));

            if(args.length == 1){
                g.addEvent(g.new Terminate(new Integer(args[0])));
            }

            g.execEvent();
        }
    }

}
