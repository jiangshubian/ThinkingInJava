package com.shu.eleventhchapter.hoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Arrays.asList(Object... o) 短板
 * Created by Administrator on 2017-05-29.
 */
public class AsListInterface {

    private static class Main {
        public static void main(String[] args) {
            //1.
            List<Snow> list = Arrays.asList(new Slush(), new Crusty(), new Power());

            //2.Won't compile:
//            List<Snow> list2 = Arrays.asList(new Light(), new Heavy());
            //Compiler says:
            // found: java.util.List<Power>
            // required: java.util.List<Snow>

            //3.Collections.addAll() does't get confused:
            List<Snow> list3 = new ArrayList<Snow>();
            Collections.addAll(list3, new Light(), new Heavy());


            //4.Give a hint using an explicit type argument specification.
            List<Snow> list4 = Arrays.<Snow>asList(new Light(), new Heavy());
        }
    }

}

class Snow {
}

class Power extends Snow {
}

class Light extends Power {
}

class Heavy extends Power {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}
