package com.aditya.ProgrammingQuestions;


import java.util.Arrays;
import java.util.List;

// Write a method that takes a list of integers and returns their sum using the reduce operation.
public class ReduceOperation {
    public static void main(String[] args) {
        System.out.println(returnSum(Arrays.asList(1, 343, 656, 76, 56, 34)));
    }
    public static int returnSum(List<Integer> nums){
           return nums.stream().reduce(0, Integer::sum);
    }
}
