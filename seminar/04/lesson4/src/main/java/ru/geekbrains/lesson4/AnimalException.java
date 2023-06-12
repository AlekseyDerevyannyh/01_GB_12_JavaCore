package ru.geekbrains.lesson4;

public abstract class AnimalException extends Exception {

    private String name;
    private int distance;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public AnimalException(String message, String name, int distance) {
        super(message);
        this.name = name;
        this.distance = distance;
    }
}
