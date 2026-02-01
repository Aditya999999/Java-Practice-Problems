package com.aditya.FunctionaInterface;

public class A_Implementation extends A{
    public static void main(String[] args) {
        i1 i = () -> System.out.println("i1 interface is called..");
        i1.nameWriter("Aditya");
        A_Implementation a = new A_Implementation();
        a.doSomething();
        System.out.println(a.calculate(4,7));
    }
}
