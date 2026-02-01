package com.aditya.ProgrammingQuestions;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Given a list of lists of integers, write a method to flatten it into a single list of integers.
public class FlatMapExample {
    public static void main(String[] args) {
        List<List<Integer>> numbers = Arrays.asList(Arrays.asList(19, 343, 656, 796, 56, 34), Arrays.asList(1, 343, 656, 76, 56, 2334), Arrays.asList(1, 343, 656, 765, 56, 34));
        List<Integer> flatResult  = numbers.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatResult);
        System.out.println("_____________________________________________");
        Set<Integer> set = new HashSet<>(flatResult);
        System.out.println(set);
    }
}
