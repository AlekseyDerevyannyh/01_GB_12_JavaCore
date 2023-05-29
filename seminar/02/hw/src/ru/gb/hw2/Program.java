package ru.gb.hw2;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = ' ';
    private static char[][] field;

    private static final int fieldSizeX = 10;
    private static final int fieldSizeY = 6;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        initialize();
        printField();
        while(true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Игрок победил!");
                break;
            }
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initialize() {
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка первой и последней строки поля
     */
    private static void printHeader() {
        System.out.print("    ");
        for (int i = 1; i <= fieldSizeX; i++)
            System.out.print(i + "   ");
        System.out.println();
    }

    /**
     * Отрисовка разделяющей строки
     */
    private static void printDelimiter() {
        System.out.print(" ─");
        for (int i = 0; i <= fieldSizeX; i++ ) {
            if (i == fieldSizeX) System.out.println("┼─");
            else System.out.print("┼───");
        }
    }

    /**
     * Отрисовка игрового поля
     */
    private static void printField() {
        printHeader();
        printDelimiter();

        for (int y = 0; y < fieldSizeY; y ++) {
            System.out.print(y + 1 + " ");
            for (int x = 0; x <= fieldSizeX; x ++) {
                if (x == fieldSizeX)    System.out.print("│ ");
                else                    System.out.print("│ " + field[x][y] + " ");
            }
            System.out.println(y + 1);
            printDelimiter();
        }

        printHeader();
    }

    /**
     * Проверка, является ли ячейка пустой
     * @param x - координаты ячейки по х
     * @param y - координаты ячейки по у
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива игрового поля)
     * @param x - координаты ячейки по х
     * @param y - координаты ячейки по у
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >=0 && x < fieldSizeX && y >=0 && y < fieldSizeY;
    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.printf("Введите координаты хода X и Y (от 1 до %d по X и от 1 до %d по Y) через пробел >>> ",
                    fieldSizeX, fieldSizeY);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка наличия выйгрыша по диагонали вправо-вверх от текущей клетки
     * @param x - координата х проверяемой клетки
     * @param y - координата у проверяемой клитки
     * @param c - символ, проверяемый на выйгрыш
     * @return
     */
    private static boolean rightUpWinCheck(int x, int y, char c) {
        if (fieldSizeX - x < WIN_COUNT)     return false;   // если вправо клеток не достаточно
        if (y - WIN_COUNT < -1)             return false;   // если вверх клеток не достаточно

        int j = y;
        for (int i = x; i < x + WIN_COUNT; i++) {
          if (field[i][j] != c)   return false;
          j--;
        }

        return true;
    }

    /**
     * Проверка наличия выйгрыша вправо от текущей клетки
     * @param x - координата х проверяемой клетки
     * @param y - координата у проверяемой клитки
     * @param c - символ, проверяемый на выйгрыш
     * @return
     */
    private static boolean rightWinCheck(int x, int y, char c) {
        if (fieldSizeX - x < WIN_COUNT)     return false;   // если вправо клеток не достаточно

        for (int i = x; i < x + WIN_COUNT; i++) {
            if (field[i][y] != c)   return false;
        }
        return true;
    }


    /**
     * Проверка наличия выйгрыша по диагонали вправо-вниз от текущей клетки
     * @param x - координата х проверяемой клетки
     * @param y - координата у проверяемой клитки
     * @param c - символ, проверяемый на выйгрыш
     * @return
     */
    private static boolean rightDownWinCheck(int x, int y, char c) {
        if (fieldSizeX - x < WIN_COUNT)     return false;   // если вправо клеток не достаточно
        if (fieldSizeY - y < WIN_COUNT)     return false;   // если вниз клеток не достаточно

        int j = y;
        for (int i = x; i < x + WIN_COUNT; i++) {
            if (field[i][j] != c)   return false;
            j++;
        }

        return true;
    }

    /**
     * Проверка наличия выйгрыша вниз от текущей клетки
     * @param x - координата х проверяемой клетки
     * @param y - координата у проверяемой клитки
     * @param c - символ, проверяемый на выйгрыш
     * @return
     */
    private static boolean downWinCheck(int x, int y, char c) {
        if (fieldSizeY - y < WIN_COUNT)     return false;   // если вниз клеток не достаточно

        for (int i = y; i < y + WIN_COUNT; i++) {
            if (field[x][i] != c)   return false;
        }
        return true;
    }
    /**
     * Проверка наличия выйгрыша
     * @param c - символ, проверяемый на выйгрыш
     * @return
     */
    private static boolean checkWin(char c) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (rightWinCheck(i, j, c))     return true;
                if (downWinCheck(i, j, c))      return true;
                if (rightUpWinCheck(i, j, c))   return true;
                if (rightDownWinCheck(i, j, c)) return true;
            }
        }
        return false;
    }

}
