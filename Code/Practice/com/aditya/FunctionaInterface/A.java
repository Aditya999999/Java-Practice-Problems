package com.aditya.FunctionaInterface;

interface i1{
    public void doSomething();
    default int calculate(int a, int b){
        return a+b;
    }
    static void nameWriter(String name){
        System.out.println("My Name is : "+ name + ".");
    }
}

public class A implements i1 {

    @Override
    public void doSomething() {
        System.out.println("Do something called...");
    }

    @Override
    public int calculate(int a, int b) {
        return i1.super.calculate(a, b);
    }
}
