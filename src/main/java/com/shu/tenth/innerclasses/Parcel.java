package com.shu.tenth.innerclasses;

/**
 * 列举内部类使用
 * Created by Administrator on 2017-05-20.
 */
public class Parcel {

    class Contents {
        private int i = 10;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    public Contents contents() {
        return new Contents();
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public void ship(String dist) {
        Contents c = contents();
        Destination d = to(dist);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        p.ship("dist");

        //模拟在外部类创建内部类对象时需要指明的对象类型为：OutObj.InnerObj的格式
        Parcel q = new Parcel();
        Parcel.Contents c = q.contents();
        Parcel.Destination d = q.to("to");
    }
}

class InnerOut {
    public void get() {
        Parcel q = new Parcel();
        Parcel.Contents c = q.contents();
    }
}
