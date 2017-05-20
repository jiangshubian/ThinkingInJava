package com.shu.eighthchapter;

/**
 * 多态向上转型(形参为基类类型)
 * Created by 123 on 2017/5/2.
 */
public class Instrument {
    public void play(Note note) {
        System.out.println("Instrument.paly:" + note);
    }
}


/**
 * Wind objects are instruments,because they are the same interface.
 */
class Wind extends Instrument {
    //redefine interface method
    @Override
    public void play(Note note) {
        System.out.println("Wind.play:" + note);
    }
}

class Music {
    /**
     * 形参指定为基类类型，方便导出类间接使用。
     * @param i Note
     */
    public static void trun(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        Music.trun(wind);
    }
}/* Output:
    Wind.play:MIDDLE_C
*///:~

/**
 * 乐符枚举类
 * Notes to play on musical instrument
 */
enum Note {
    MIDDLE_C, C_SHARP, B_FLAT;//Etc..
}