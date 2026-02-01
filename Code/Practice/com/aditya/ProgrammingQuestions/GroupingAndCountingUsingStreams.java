package com.aditya.ProgrammingQuestions;


//Given a list of strings,
// write a method to group the strings by their length and count the number of strings of each length.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndCountingUsingStreams {
    public static void main(String[] args) {
        List<String> stringGroups = Arrays.asList("Aditya", "Dubey", "Haiderganj", "Ayodhya", "Birlasoft");
        Map<Integer, Long> map = stringGroups.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map);
    }
}
