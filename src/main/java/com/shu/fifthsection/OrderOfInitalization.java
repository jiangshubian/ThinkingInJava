package com.shu.fifthsection;

/**
 * Created by Administrator on 2017-04-10.
 */
public class OrderOfInitalization {
    public static void main(String[] args) {
        House h = new House();
        House h2= new House();
        h.f(1);
        h2.f(2);
    }
}

//When the constructor is called to create a Window object, you'll see a message.
class Window {
    public Window(int marker) {
        System.out.println("marker:" + marker);
    }
}

/**
 * 1)static blobk is first..
 * 2)The object block is equivalent to attribute,then print them what look up the order
 * 3)constructor is next.
 * 4)method is end.(be called)
 */
class House{
    Window w1 = new Window(1); //Before constructor

    //Object block..
    {
        Window w5 = new Window(5);
    }

    public House() {
        w3 = new Window(33); //Reinitalize w3
    }

    Window w2 = new Window(2); //After constructor
    void f(int f){
        System.out.println("f()..."+f);
    }
    static Window w6 = new Window(6); //static attribute

    Window w3 = new Window(3); //At end

    //Static block..
    static{
        Window w4 = new Window(4);
    }
}/* Output:
    marker:6
    marker:4

    marker:1
    marker:5
    marker:2
    marker:3
    marker:33

    marker:1
    marker:5
    marker:2
    marker:3
    marker:33

    f()...1
    f()...2
*/
