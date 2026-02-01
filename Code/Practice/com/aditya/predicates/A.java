package com.aditya.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class A {
    public static void main(String[] args) {
        List<Country> list = new ArrayList<>();
        list.add(new Country("India", 909932312));
        list.add(new Country("America", 909932908));
        list.add(new Country("Indonesia", 909932334));

        Predicate<String> p = name -> name.startsWith("I");
        for(Country c: list){
            if (p.test(c.getName())){
                System.out.println(c.getName());
            }
        }
    }
}
