package org.example;

public class Demo {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee americanCoffee = coffeeStore.orderCoffee("coffee.american");
        Coffee latteCoffee = coffeeStore.orderCoffee("coffee.latte");
        System.out.println(americanCoffee);
        System.out.println(latteCoffee);
    }
}