package org.example;

public class Demo {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee americanCoffee = coffeeStore.orderCoffee("American Coffee");
        Coffee latteCoffee = coffeeStore.orderCoffee("Latte Coffee");
        System.out.println(americanCoffee);
        System.out.println(latteCoffee);
    }
}