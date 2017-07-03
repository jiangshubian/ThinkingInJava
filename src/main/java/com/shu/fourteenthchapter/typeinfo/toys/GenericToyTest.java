package com.shu.fourteenthchapter.typeinfo.toys;

/**
 * Created by Administrator on 2017-06-17.
 */
public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> fancyToyClass = FancyToy.class;
        //Produces exact type
        FancyToy fancyToy = fancyToyClass.newInstance();
        Class<? super FancyToy> up = fancyToyClass.getSuperclass();
        //This won't compile:
//        Class<Toy> ups = fancyToyClass.getSuperclass();
        //Only produces Object:
        Object obj = up.newInstance();
        System.out.println(obj.getClass().getSimpleName());
    }
}
