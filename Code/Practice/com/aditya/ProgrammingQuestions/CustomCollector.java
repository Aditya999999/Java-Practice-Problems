package com.aditya.ProgrammingQuestions;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Write a custom collector to concatenate all strings in a list, separated by a comma.
public class CustomCollector {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Aditya", "Dubey", "Haiderganj", "Ayodhya");
        String result = strings.stream().collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
