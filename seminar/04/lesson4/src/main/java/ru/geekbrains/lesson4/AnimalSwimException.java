package ru.geekbrains.lesson4;

public class AnimalSwimException extends AnimalException{
    public AnimalSwimException(String message, String name, int distance) {
        super(message, name, distance);
    }
}
