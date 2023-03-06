package org.example;

public class Tiramisu extends Dessert{
    private String name;

    public Tiramisu() {
        this.name = "Tiramisu";
    }

    @Override
    public String toString() {
        return "Tiramisu{" +
                "name='" + name + '\'' +
                '}';
    }
}
