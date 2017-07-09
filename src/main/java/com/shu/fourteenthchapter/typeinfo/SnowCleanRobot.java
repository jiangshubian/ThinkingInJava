package com.shu.fourteenthchapter.typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017-07-09.
 */
public class SnowCleanRobot implements Robot {
    private String name;

    public SnowCleanRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "Snow Series 11";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can shove snow.";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " shoveling snow.");
                    }
                },
                new Operation() {

                    @Override
                    public String description() {
                        return name + " can chip ice.";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " chipping ice.");
                    }
                }
        );
    }


    public static class Test {
        public static void main(String[] args) {
            Robot.Test.test(new SnowCleanRobot("Slusher"));
        }
    }
}
