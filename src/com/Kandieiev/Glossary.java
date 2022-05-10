package com.Kandieiev;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class Glossary {
    private static final String pathOut = "D:/Лабораторные/Slovak/SlovakeFinalTest/test.txt";
    public static void main(String[] args) throws IOException {
        String text = readFile("harry.txt");
        String [] words = splitOnWords(text);
        headerCreate();

        Map<String, Integer> map = getMap(words);
        Map<String, Integer> sortedMap = sortMap(map, map.size());
        System.out.println(sortedMap);
        writeToReadyFile(sortMap(map, 20).toString()+"\n");

        List<String> proper = new ArrayList<>();
        for (String element: map.keySet()) {
            if (element.length()>1) {
                if (element.substring(0, 1).toUpperCase(Locale.ROOT).equals(element.substring(0, 1))
                        && element.substring(1, 2).toLowerCase(Locale.ROOT).equals(element.substring(1, 2))) {
                    proper.add(element);
                }
            }
        }
        Collections.sort(proper);
        writeToReadyFile("We have: "+Integer.toString(proper.size()) + " names.\n");
        writeToReadyFile(proper.toString()+"\n");



    }

    public static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder("");
        Files.lines(Paths.get(path))
                .forEach(line-> sb.append(line
                        .replaceAll("[^A-Za-z ]", "")));
        return sb.toString();
    }
    public static String[] splitOnWords(String text){
        return text.split(" +");
    }

    public static Map<String, Integer> getMap (String [] words){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (String word: words) {
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }
            else {
                map.put(word, 1);
            }
        }
        return map;
    }
    public static Map <String, Integer> sortMap(Map<String , Integer> map, int limit){
        Map<String,Integer> sorted =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(limit)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sorted;
    }

    public static void headerCreate() throws IOException {
        String out = "===================Final Exam===================";
        out = out + "\n============Made by Pavlo Kandieiev=============";
        out = out + "\n=============I write this Java code=============";
        out = out + "\n++++++++++++++++++++++++++++++++++++++++++++++++";
        out = out + "\n                Thx for watching                \n\n\n";
        Files.write(Paths.get(pathOut), out.getBytes(StandardCharsets.UTF_8));
    }
    public static void writeToReadyFile(String out) throws IOException {
        Files.write(Paths.get(pathOut), out.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }

}
