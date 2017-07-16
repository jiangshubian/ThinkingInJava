package com.shu.fourteenthchapter.typeinfo;

import com.shu.util.Null;

import java.util.List;

/**
 * 机器人接口
 * 定义名称、模型和描述Robot行为的List<Operation>
 * Created by Administrator on 2017-07-09.
 */
public interface Robot {
    String name();
    String model();
    List<Operation> operations();

    class Test{ //接口属性
        public static void test(Robot robot){
            if(robot instanceof Null) System.out.println("[Null Robot.]");
            System.out.println("Robot name:"+robot.name());
            System.out.println("Robot model:"+robot.model());
            for (Operation o : robot.operations()) {
                System.out.println(o.description());
                o.command();
            }
        }
    }
}
