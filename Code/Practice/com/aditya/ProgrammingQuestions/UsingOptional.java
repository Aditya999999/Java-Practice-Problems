package com.aditya.ProgrammingQuestions;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Write a method that finds the first even number in a list.
// Return an Optional<Integer> to handle the case where no even numbers are found.
public class UsingOptional {
    public static void main(String[] args) {
        System.out.println(firstEvenNumber(Arrays.asList(3,43,45,65,23,65)));
    }
    public static Optional<Integer> firstEvenNumber(List<Integer> numbers){
        return numbers.stream().filter(x -> x % 2 == 0).findFirst();
    }
}
