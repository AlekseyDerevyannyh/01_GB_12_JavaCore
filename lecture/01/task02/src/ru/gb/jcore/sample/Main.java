package ru.gb.jcore.sample;
import ru.gb.jcore.regular.OtherClass;

/**
 * Основной класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 * */

public class Main {
	/**
	 * Точка входа в программу. С неё всегда всё начинается.
	 * */
	public static void main(String[] args) {
		System.out.println("Hello, world");
		int result = OtherClass.sum(2, 2);
		System.out.println(OtherClass.decorate(result));
	}
}