package com.aditya.ProgrammingQuestions;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Given a list of strings, write a method to sort the strings by their length in descending order.
public class SortingUsingStreams {
    public static void main(String[] args) {
        System.out.println(sortByLength(Arrays.asList("Aditya", "Dubey", "Haiderganj", "Ayodhya")));
    }
    public static List<String> sortByLength(List<String> string){
        return string.stream().sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())).collect(Collectors.toList());
    }
}
