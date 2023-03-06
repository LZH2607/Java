package org.example;

public class CoffeeFactory {
    public Coffee createCoffee(String name) {
        Coffee coffee = null;
        if("American Coffee".equals(name)) {
            coffee = new AmericanCoffee();
        } else if("Latte Coffee".equals(name)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException();
        }
        return coffee;
    }
}
