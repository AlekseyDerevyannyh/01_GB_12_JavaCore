package ru.geekbrains.lesson4;

public abstract class Animal {

    protected  int distance;
    protected final String name;

    public Animal(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    abstract void swim(int distance) throws AnimalSwimException;
    abstract void run(int distance) throws AnimalRunException;

}
