package com.shu.Cloneable;

import org.junit.Test;

import java.util.Date;

/**
 * Created by Administrator on 2017-07-22.
 */
public class AdministractorTest {
    @Test


    public void testAdministratorClone() throws CloneNotSupportedException {


        Administrator a1 = new Administrator(new User("Kent", "123456", new Date()), true);


        Administrator a2 = a1;


        Administrator a3 = (Administrator) a1.clone();


        System.out.println(a1 == a2);            // true


        System.out.println(a1.equals(a2));        // true


        System.out.println(a1 == a3);            // false


        System.out.println(a1.equals(a3));        // true


        System.out.println(a1.getUser() == a3.getUser());        //true ! It's not our expected!!!!!


        System.out.println(a1.getUser().equals(a3.getUser()));    //true


    }

}
