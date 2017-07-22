package com.shu.Cloneable;

import org.junit.Test;

import java.util.Date;

/**
 * Created by Administrator on 2017-07-22.
 */
public class UserTestCase {
    @Test
    public void testUserClone() throws CloneNotSupportedException {


        User u1 = new User("Kent", "123456", new Date());


        User u2 = u1;


        User u3 = (User) u1.clone();


        System.out.println(u1 == u2);        // true


        System.out.println(u1.equals(u2));    // true


        System.out.println(u1 == u3);        // false


        System.out.println(u1.equals(u3));    // true


    }

}
