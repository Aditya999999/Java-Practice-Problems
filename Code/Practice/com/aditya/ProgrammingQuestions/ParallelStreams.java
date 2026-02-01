package com.aditya.ProgrammingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreams {
    public static void main(String[] args) {
        System.out.println(sortByLengthDescParallel(Arrays.asList("Aditya", "Dubey", "Haiderganj", "Ayodhya")));
    }
    public static List<String> sortByLengthDescParallel(List<String> string){
        return string.parallelStream().sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())).collect(Collectors.toList());
    }
}
