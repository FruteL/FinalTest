package com.Kandieiev;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicates {
    public  static  boolean hasDuplicates(int[] array){
        Arrays.sort(array);
        Set<Integer> set = new HashSet<>();
        for (int i: array) {
            if(!set.add(i)){
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        int[] array = {1,5,3,6,2,9,33,21};
        System.out.println(hasDuplicates(array));  // false
        array[5] = 1;
        System.out.println(hasDuplicates(array)); // true
    }
}
