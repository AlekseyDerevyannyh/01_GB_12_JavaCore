package ru.gb.hw1.sample;

import ru.gb.hw1.regular.OtherClass;
import ru.gb.hw1.regular.Decorator;

/**
 * Основной класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 * */

public class Main {
    /**
     * Точка входа в программу. С неё всегда всё начинается.
     * */
    public static void main(String[] args) {
        int result = OtherClass.sum(2, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.sub(6, 2);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.mul(3, 3);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.div(20, 4);
        System.out.println(Decorator.decorate(result));
    }
}