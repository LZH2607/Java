package org.example;

public class MatchaMousse extends Dessert{
    private final String name;

    public MatchaMousse() {
        this.name = "Matcha Mousse";
    }

    @Override
    public String toString() {
        return "MatchaMousse{" +
                "name='" + name + '\'' +
                '}';
    }
}
