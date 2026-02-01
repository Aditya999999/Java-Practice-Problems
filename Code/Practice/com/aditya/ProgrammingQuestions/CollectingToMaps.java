package com.aditya.ProgrammingQuestions;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Given a list of strings, write a program to create a map where the keys are the first characters of the strings and the values are lists of strings starting with that character.
public class CollectingToMaps {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Aditya", "Dubey", "Haiderganj", "Ayodhya");
        Map<Character, List<String >> map = strings.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map);
    }
}
