package org.example;

public class LatteCoffee extends Coffee{
    private final String name;

    public LatteCoffee() {
        this.name = "Latte Coffee";
    }

    @Override
    public String toString() {
        return "LatteCoffee{" +
                "name='" + name + '\'' +
                '}';
    }
}
