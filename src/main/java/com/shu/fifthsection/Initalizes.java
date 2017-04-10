package com.shu.fifthsection;

/**
 * 构造方法验证
 * Created by 123 on 2017/4/9.
 * @author jiangshubian
 */
public class Initalizes {

    public static void main(String[] args) {
        Person person = new Person();
        /* Out:
            name:null
            likes:girl
         */
        Person person2 = new Person("dog");
        /* Out:
            name:dog
            likes:girl
         */

    }
}
