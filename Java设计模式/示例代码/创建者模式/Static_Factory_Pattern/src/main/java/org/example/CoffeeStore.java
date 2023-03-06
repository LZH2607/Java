package org.example;

public class CoffeeStore {
    public Coffee orderCoffee(String name) {
        return CoffeeFactory.createCoffee(name);
    }
}
