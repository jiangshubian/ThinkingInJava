package com.shu.Fifteenthchapter.generic;

import com.shu.util.Sets;

import java.util.EnumSet;
import java.util.Set;

import static com.shu.Fifteenthchapter.generic.Watercolors.*;

/**
 * java.util.EnumSet：对枚举的处理工具类
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-07-21 16:38
 * @Version: 1.0.0
 */
public class WaterColorSets {

    public static void main(String[] args) {
        //create new set which copy Watercolors enum from BRILLIANT_RED to VIRIDIAN_HUE
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("Set1；" + set1);
        System.out.println("Set2；" + set2);

        System.out.println("Union(set1,set2):" + Sets.union(set1, set2));//set1 and set2 generate union

        Set<Watercolors> subset = Sets.intersection(set1, set2); // generate intersection
        System.out.println("intersection(set1,set2):" + subset);

        System.out.println("difference(set1,subset):" + Sets.difference(set1, subset));//generate difference
        System.out.println("difference(set2,subset):" + Sets.difference(set2, subset));

        System.out.println("complement(set1,set2):" + Sets.complement(set1, set2));
    }

}/*Out:
Set1；[BRILLIANT_RED, CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE]
Set2；[CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER, BURNT_UMBER]
Union(set1,set2):[RAW_UMBER, BURNT_SIENNA, MAGENTA, PHTHALO_BLUE, BRILLIANT_RED, PERMANENT_GREEN, SAP_GREEN, CRIMSON, BURNT_UMBER, ROSE_MADDER, COBALT_BLUE_HUE, VIOLET, CERULEAN_BLUE_HUE, YELLOW_OCHRE, VIRIDIAN_HUE, ULTRAMARINE]
intersection(set1,set2):[COBALT_BLUE_HUE, CERULEAN_BLUE_HUE, VIRIDIAN_HUE, PHTHALO_BLUE, PERMANENT_GREEN, ULTRAMARINE]
difference(set1,subset):[ROSE_MADDER, VIOLET, MAGENTA, BRILLIANT_RED, CRIMSON]
difference(set2,subset):[BURNT_UMBER, RAW_UMBER, YELLOW_OCHRE, BURNT_SIENNA, SAP_GREEN]
complement(set1,set2):[RAW_UMBER, BURNT_SIENNA, MAGENTA, BRILLIANT_RED, SAP_GREEN, CRIMSON, ROSE_MADDER, BURNT_UMBER, VIOLET, YELLOW_OCHRE]
*///~
