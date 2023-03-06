package org.example;

public class Prototype implements Cloneable{
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
