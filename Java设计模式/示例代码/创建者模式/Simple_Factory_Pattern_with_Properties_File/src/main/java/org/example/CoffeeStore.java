package org.example;

public class CoffeeStore {
    public Coffee orderCoffee(String name) {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        return coffeeFactory.createCoffee(name);
    }
}
