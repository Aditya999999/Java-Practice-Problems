package com.aditya.predicates;

public class Country {
    private String name;
    private Integer population;

    public Country(String name, Integer population){
        super();
        this.name = name;
        this.population = population;
    }

    public String getName(){
        return name;
    }

    public Integer getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
