package org.example;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype1 = new Prototype();
        Prototype prototype2 = prototype1.clone();
        System.out.println(prototype1);
        System.out.println(prototype2);
        System.out.println(prototype1 == prototype2);
    }
}
