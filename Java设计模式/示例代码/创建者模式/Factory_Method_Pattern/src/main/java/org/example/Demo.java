package org.example;

public class Demo {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();

        AmericanCoffeeFactory americanCoffeeFactory = new AmericanCoffeeFactory();
        coffeeStore.setCoffeeFactory(americanCoffeeFactory);
        Coffee coffee1 = coffeeStore.orderCoffee();
        System.out.println(coffee1);

        LatteCoffeeFactory latteCoffeeFactory = new LatteCoffeeFactory();
        coffeeStore.setCoffeeFactory(latteCoffeeFactory);
        Coffee coffee2 = coffeeStore.orderCoffee();
        System.out.println(coffee2);
    }
}