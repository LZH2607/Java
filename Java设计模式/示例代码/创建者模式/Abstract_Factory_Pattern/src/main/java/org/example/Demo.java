package org.example;

public class Demo {
    public static void main(String[] args) {
        AmericanFoodFactory americanFoodFactory = new AmericanFoodFactory();
        Coffee coffee1 = americanFoodFactory.createCoffee();
        Dessert dessert1 = americanFoodFactory.createDessert();
        System.out.println(coffee1);
        System.out.println(dessert1);

        ItalianFoodFactory italianFoodFactory = new ItalianFoodFactory();
        Coffee coffee2 = italianFoodFactory.createCoffee();
        Dessert dessert2 = italianFoodFactory.createDessert();
        System.out.println(coffee2);
        System.out.println(dessert2);
    }
}