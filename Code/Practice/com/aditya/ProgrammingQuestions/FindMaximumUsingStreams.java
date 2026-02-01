package com.aditya.ProgrammingQuestions;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Write a method to find the maximum value in a list of integers using the Stream API.
public class FindMaximumUsingStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,54,767,34,376,723,8);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println(max);
    }
}
