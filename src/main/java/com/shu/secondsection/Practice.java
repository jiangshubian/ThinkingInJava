//: Object/Practice.class
package com.shu.secondsection;

/**的所发生的
 * Created by 123 on 2017/4/8.
 *
 * @author jiangshubian
 * @version 1.0
 */
public class Practice {

    /**
     * show object init value
     *
     * @param args input String arr
     * @throws - No exceptions throw
     */
    public static void main(String[] args) {
//        showInitObjectValue();
        basePackageTranstion();
    }

    /**
     * This method is to show what object init value.
     *
     * @param - no parameters in
     * @throws - no exceptions throw
     */
    static void showInitObjectValue() {
        User user = new User();
        System.out.println("String:" + user.name);
        System.out.println("char:" + user.smallnage);
        System.out.println("int:" + user.age);
        System.out.println("boolean:" + user.boy);
        System.out.println("float:" + user.weight);

        User user2 = new User();
        System.out.println("String2:" + user.name);
    }

    /**
     * This method is to show base type from package type and transtion come.
     *
     * @param - no parameters in
     * @throws - no exceptions throw
     */
    static void basePackageTranstion() {
        Integer e = new Integer(100);
        int y = 1000;
        Integer i = y;//Integer.valueOf(y); //装箱
        int cc = i;// i.intValue();//结箱
        Integer ii = y;
        System.out.println("i:" + i + ",y:" + y + ",==:" + (i == ii)); //y=100 i == ii==>true ;y=1000 i == ii==>false ;

        boolean c = false;
        Boolean b = c;
        System.out.println("c:" + c + ",b:" + b+ ",==:" + (c == b));
    }
}
/* Output:
    String:null
    char:
    int:0
    boolean:false
    float:0.0
 *///：~
