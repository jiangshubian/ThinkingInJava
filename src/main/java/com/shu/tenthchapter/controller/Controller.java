package com.shu.tenthchapter.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件处理类
 * Created by Administrator on 2017-05-21.
 */
public class Controller {
    //A class from java.util.to hold Event objects.
    private List<Event> eventList = new ArrayList<Event>();

    protected void addEvent(Event event){
        eventList.add(event);
    }
    public void execEvent(){
        while(eventList.size() > 0){
            //Make a copy so you're not modifying the list while you're selecting the elements in it.
            for (Event e : new ArrayList<Event>(eventList)){
                if(e.isReady()){
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
