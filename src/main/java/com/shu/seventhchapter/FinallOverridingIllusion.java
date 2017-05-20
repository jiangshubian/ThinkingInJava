package com.shu.seventhchapter;

/**
 * Created by 123 on 2017/5/1.
 */
public class FinallOverridingIllusion extends OverridingPrivate{
    public void g(){
        System.out.println("FinallOverridingIllusion.g");
    }
//    @Override
//    public void h(){ //overrden method is final
//        System.out.println("OverridingPrivate.h");
//    }
    public static void main(String[] args) {
        FinallOverridingIllusion f = new FinallOverridingIllusion();
        f.g();

        //up cast class
        OverridingPrivate o = f;
//        o.g(); //father class with this method is private
        o.h();//ok
    }
}

class WithFinals{
    private void g(){
        System.out.println("WithClass.g");
    }
}

class OverridingPrivate extends WithFinals{
    /**
     * final method
     */
    public final void h(){
        System.out.println("OverridingPrivate.h");
    }
    private void g(){
        System.out.println("OverridingPrivate.g");
    }
}