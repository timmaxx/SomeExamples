package timmax.generics.p05;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A {
/*    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (T t : src) {
            dest.add(t);
        }
*//*
        for(T t : dest) {
            src.add(t);
        }
*//*
    }*/

    public static void main(String[] args) {
        List<Number> nums = Arrays.<Number>asList(4.1F, 0.2F);
        List<Integer> ints = Arrays.asList(1, 2);
        System.out.println("nums = " + nums);
        Collections.copy(nums, ints);
        System.out.println("nums = " + nums);
    }
}
