package com.aditya.ProgrammingQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Write a method that takes a list of integers and returns a list of the squares of all even numbers.
public class FilterAndMapUsingStreams {
    public static void main(String[] args) {
        System.out.println(evenSquares());
    }
    public static List<Integer> evenSquares(){
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 100; i++)
            numbers.add(i);
        return numbers.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList());

    }
}
