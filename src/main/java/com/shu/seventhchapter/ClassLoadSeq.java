package com.shu.seventhchapter;

/**
 * Created by 123 on 2017/5/1.
 */
public class ClassLoadSeq extends Insect {
    String name = "ClassLoadSeq";
    private int k = printInit("ClassLoadSeq.k printInit");

    public ClassLoadSeq() {
        super();
        System.out.println("ClassLoadSeq constructor");
        System.out.println("k:" + k + ",j:" + j);
        f();
    }

    private static int x2 = printInit("ClassLoadSeq.x2 .printInit");

    public static int getX2(){
        return x2;
    }

    @Override
    public void f() {
        System.out.println("subclass.f()");
        System.out.println("print name:" + name);
    }
}/*
    Insect.printInit
    ClassLoadSeq.x2 .printInit
    Insect constructor
    i:9,j:0
    subclass.f()
    print name:null
    fatherclass.g()
    ClassLoadSeq.k printInit
    ClassLoadSeq constructor
    k:47,j:20
    subclass.f()
    print name:ClassLoadSeq
*/

class Insect {
    private int i = 9;
    protected int j;
    String name = "Insect";

    /**
     * 构造函数
     */
    public Insect() {
        System.out.println("Insect constructor");
        System.out.println("i:" + i + ",j:" + j);
        f();
        g();
        this.j = 20;
    }

    /**
     * 在构造器中调用了子类重写的方法时，都是执行了子类的方法；调用的属性也是属于子类本身的属性。（这样可能导致初始化属性值异常）
     */
    public void f() {
        System.out.println("fatherclass.f()");
        System.out.println("print name:" + name);
    }
    public void g() {
        System.out.println("fatherclass.g()");
    }

    /**
     * static修饰的属性会随着类加载而初始化。
     */
    private static int x1 = printInit("Insect.printInit");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

class LoadTest{
    public static void main(String[] args) {
        ClassLoadSeq.getX2();
        ClassLoadSeq c = new ClassLoadSeq();
    }
}