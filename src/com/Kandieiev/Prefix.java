package com.Kandieiev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prefix {
    public static String prefix(String[] array) {
        int minLenght = 10;
        String shortestWord = "";
        for (int i = 0; i < array.length; i++) {
            if(array[i].length() < minLenght){
                minLenght = array[i].length();
                shortestWord = array[i];
            }
        }
        for (int i = 0; i < minLenght; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if(array[j].startsWith(shortestWord.substring(0, shortestWord.length()-i))){

                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag){
                return shortestWord.substring(0, shortestWord.length()-i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] array = {"abc", "abcd", "abfce", "abcac"} ;

        System.out.println(prefix(array));  // ab

        String[] array2 = {"abc", "abcd", "abce", "abcac"} ;

        System.out.println(prefix(array2)); // abc

    }
}
