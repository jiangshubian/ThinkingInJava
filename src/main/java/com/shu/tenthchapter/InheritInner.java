package com.shu.tenthchapter;

/**
 * 内部类继承
 * Created by Administrator on 2017-05-22.
 */
public class InheritInner extends WithInner.Inner{
    public InheritInner(WithInner wi) {
        wi.super(10);//必须由外部类间接初始化内部类构造： enclosingClassReference.super()语法
    }
    public static class Test{
        public static void main(String[] args) {
            InheritInner ii = new InheritInner(new WithInner());
        }
    }
}

class WithInner {
    class Inner {
        public Inner(int i){
            System.out.println(i);
        }
    }
}