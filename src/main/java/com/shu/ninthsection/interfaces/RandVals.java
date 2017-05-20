package com.shu.ninthsection.interfaces;

import java.util.Random;

/**
 * Created by Administrator on 2017-05-20.
 */
public interface RandVals {
    Random r = new Random(47);

    int RANDOM_INT = r.nextInt();
    double RANDOM_DOUBLE = r.nextDouble();
    float RANDON_FLOAT = r.nextFloat();
}
