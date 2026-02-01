package com.aditya.ProgrammingQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class mapIteration {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Aditya");
        map.put(2, "Ashwin");
        map.put(3, "Madhu");
        map.put(4, "Deepika");

        // map.forEach((k,v) -> System.out.println("Key:"+ k + ", values:"+v));

        map.entrySet().stream().forEach(entry -> {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        });

        Map<Integer, String> transformedMap = map.entrySet().stream()
                .filter(entry -> entry.getValue() == "Aditya")
                .collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue ));

        transformedMap.forEach(
                (k, v) -> {
                    System.out.println("Key: " + k + " Value: " + v);
                }
        );
    }
}
