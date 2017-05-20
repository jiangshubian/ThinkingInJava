package com.shu.seventhchapter;

/**
 * reusing/FinalArguments.class
 * Created by Administrator on 2017-04-26.
 */
public class FinalArguments {
    void with(final Gizmo g){
        //! g = new Gizmo(); //illegal -- g is final
        if (g==null) return;
        g.spin();
    }

    void without(Gizmo g){
        g = new Gizmo(); // ok -- g is not final
        g.spin();
    }
    int g(final int i){
        // i += 1; // illegal -- i is final
        return i+1;
    }
    int gWithout(int i){
         i += 1; // illegal -- i is final
        return i;
    }

    public static void main(String[] args) {
        FinalArguments finalArguments = new FinalArguments();
        finalArguments.with(null);
        finalArguments.without(null);
    }
}

class Gizmo{
    public void spin(){
        System.out.println("Gizmo.spin");
    }
}
