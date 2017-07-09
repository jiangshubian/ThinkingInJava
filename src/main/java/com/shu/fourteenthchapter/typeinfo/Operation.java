package com.shu.fourteenthchapter.typeinfo;

/**
 * 命令模式类型
 * Created by Administrator on 2017-07-09.
 */
public interface Operation {

    /**
     * 命令描述
     * @return
     */
    String description();

    /**
     * 需要执行的命令
     */
    void command();
}
