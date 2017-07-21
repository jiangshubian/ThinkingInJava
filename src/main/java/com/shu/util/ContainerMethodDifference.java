package com.shu.util;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author: jiangshubian
 * @Description:
 * @Date: Create in 2017-07-21 17:10
 * @Version: 1.0.0
 */
public class ContainerMethodDifference {
    /**
     * 通过类型创建一个类方法的Set
     *
     * @param type
     * @return
     */
    public static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<String>();
        for (Method method : type.getMethods())
            result.add(method.getName());
        return result;
    }

    public static Set<String> interfaces(Class<?> type) {
        System.out.println("Show type simple name:" + type.getSimpleName());
        Set<String> result = new HashSet<String>();
        for (Class<?> in : type.getInterfaces())
            result.add(in.getSimpleName());
        return result;
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    public static void difference(Class<?> superset, Class<?> subset) {
        System.out.println("superset simple name:" + superset.getSimpleName() + " extends " + subset.getSimpleName());
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);//don't show 'Object' methods
        System.out.println("comp:" + comp);
        System.out.println("interfaces(superset):" + interfaces(superset));
    }

    public static void main(String[] args) {
//        Collection
        System.out.println("Collection.class:" + methodSet(Collection.class));
        System.out.println(interfaces(Collection.class));
        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);

        //Map
        System.out.println(methodSet(Map.class));
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
}
