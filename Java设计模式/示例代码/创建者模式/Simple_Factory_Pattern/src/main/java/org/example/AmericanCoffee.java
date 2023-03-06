package org.example;

public class AmericanCoffee extends Coffee{
    private final String name;

    public AmericanCoffee() {
        this.name = "American Coffee";
    }

    @Override
    public String toString() {
        return "AmericanCoffee{" +
                "name='" + name + '\'' +
                '}';
    }
}
