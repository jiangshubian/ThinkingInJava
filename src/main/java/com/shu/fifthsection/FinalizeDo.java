package com.shu.fifthsection;

/**
 * Created by Administrator on 2017-04-10.
 */
public class FinalizeDo {
    boolean checkOut = false;

    public FinalizeDo(boolean checkOut) {
        this.checkOut = checkOut;
    }

    void checkIn() {
        checkOut = false;
        System.out.println("checked in:"+checkOut);
    }

    /**
     * In order to show if the object is checked in.
     */
    protected void finalize() {
        if (checkOut) {
            System.out.println("Error: checked out.");
        }
    }

    public static void main(String[] args) {
        FinalizeDo finalizeDo = new FinalizeDo(true);
        //Proper cheanup:
        finalizeDo.checkIn();

//        Drop the reference,forget to chean up:
        new FinalizeDo(true);
        //Force garbage collection & finalization:
        System.gc();
    }   /* Output:
        checked in:false
        Error: checked out. //something may show.
        */

}
