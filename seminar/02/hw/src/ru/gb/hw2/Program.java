package ru.gb.hw2;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final int WIN_COUNT = 5;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = ' ';
    private static char[][] field;
    private static final int fieldSizeX = 10;
    private static final int fieldSizeY = 6;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        while (true){
            initialize();
            printField();
            while (true){
                int[] coordinate;
                coordinate = humanTurn();
                printField(coordinate[0], coordinate[1]);
                if (gameCheck(DOT_HUMAN, "Вы победили!")) {
                    break;
                }
                coordinate = aiTurn();
                System.out.println("Ход ИИ:");
                printField(coordinate[0], coordinate[1]);

                if (gameCheck(DOT_AI, "ИИ победил!"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да)");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
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
     * Отрисовка игрового поля c подсветкой символа
     * @param xColor - координата х подсвечиваемого символа
     * @param yColor - координата у подсвечиваемого символа
     */
    private static void printField(int xColor, int yColor) {
        printHeader();
        printDelimiter();
        for (int y = 0; y < fieldSizeY; y ++) {
            System.out.print(y + 1 + " ");
            for (int x = 0; x <= fieldSizeX; x ++) {
                if (x == fieldSizeX)                    System.out.print("│ ");
                else if (x == xColor && y == yColor)    System.out.print("│ " + ANSI_RED + field[x][y] + ANSI_RESET +" ");
                else                                    System.out.print("│ " + field[x][y] + " ");
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
     * @return - возвращает массив с координатой хода [0] - x, [1] - y
     */
    private static int[] humanTurn() {
        int x, y;
        do {
            System.out.printf("Введите координаты хода X и Y (от 1 до %d по X и от 1 до %d по Y) через пробел >>> ",
                    fieldSizeX, fieldSizeY);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
        return new int[]{x, y};
    }

    /**
     * Проверка наличия выйгрыша по диагонали вправо-вверх от текущей клетки
     * @param x - координата х проверяемой клетки
     * @param y - координата у проверяемой клитки
     * @param c - символ, проверяемый на выйгрыш
     * @return
     */
    private static boolean rightUpWinCheck(int x, int y, char c, int winCount) {
        if (fieldSizeX - x < winCount)     return false;   // если вправо клеток не достаточно
        if (y - winCount < -1)             return false;   // если вверх клеток не достаточно

        int j = y;
        for (int i = x; i < x + winCount; i++) {
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
    private static boolean rightWinCheck(int x, int y, char c, int winCount) {
        if (fieldSizeX - x < winCount)     return false;   // если вправо клеток не достаточно

        for (int i = x; i < x + winCount; i++) {
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
    private static boolean rightDownWinCheck(int x, int y, char c, int winCount) {
        if (fieldSizeX - x < winCount)     return false;   // если вправо клеток не достаточно
        if (fieldSizeY - y < winCount)     return false;   // если вниз клеток не достаточно

        int j = y;
        for (int i = x; i < x + winCount; i++) {
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
    private static boolean downWinCheck(int x, int y, char c, int winCount) {
        if (fieldSizeY - y < winCount)     return false;   // если вниз клеток не достаточно

        for (int i = y; i < y + winCount; i++) {
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
                if (rightWinCheck(i, j, c, WIN_COUNT))     return true;
                if (downWinCheck(i, j, c, WIN_COUNT))      return true;
                if (rightUpWinCheck(i, j, c, WIN_COUNT))   return true;
                if (rightDownWinCheck(i, j, c, WIN_COUNT)) return true;
            }
        }
        return false;
    }

    /**
     * Проверка на ничью
     * @return
     */
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     * @param c - символ (игрок или ИИ)
     * @param str - победное сообщение
     * @return
     */
    static boolean gameCheck(char c, String str) {
        if (checkWin(c)){
            System.out.println(str);
            return true;
        }
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Ход компьютера
     * @return возвращает массив с координатой хода [0] - x, [1] - y
     */
//    private static int[] aiTurn() {
//        int x, y;
//        do
//        {
//            x = random.nextInt(fieldSizeX);
//            y = random.nextInt(fieldSizeY);
//        }
//        while (!isCellEmpty(x, y));
//        field[x][y] = DOT_AI;
//        return new int[]{x, y};
//    }

    /**
     * Ход компьютера
     * @return возвращает массив с координатой хода [0] - x, [1] - y
     */
    private static int[] aiTurn() {
        int[] coordinate;
        coordinate = forecastCheckWin(DOT_AI, WIN_COUNT);
        if (coordinate != null) {
            field[coordinate[0]][coordinate[1]] = DOT_AI;
            return new int[]{coordinate[0], coordinate[1]};
        }

        coordinate = forecastCheckWin(DOT_HUMAN, WIN_COUNT);
        if (coordinate != null) {
            field[coordinate[0]][coordinate[1]] = DOT_AI;
            return new int[]{coordinate[0], coordinate[1]};
        }

        coordinate = forecastCheckWin(DOT_HUMAN, WIN_COUNT - 1);
        if (coordinate != null) {
            field[coordinate[0]][coordinate[1]] = DOT_AI;
            return new int[]{coordinate[0], coordinate[1]};
        }

        coordinate = forecastCheckWin(DOT_AI, WIN_COUNT - 1);
        if (coordinate != null) {
            field[coordinate[0]][coordinate[1]] = DOT_AI;
            return new int[]{coordinate[0], coordinate[1]};
        }

        coordinate = forecastCheckWin(DOT_HUMAN, WIN_COUNT - 2);
        if (coordinate != null) {
            field[coordinate[0]][coordinate[1]] = DOT_AI;
            return new int[]{coordinate[0], coordinate[1]};
        }

        coordinate = new int[2];
        do
        {
            coordinate[0] = random.nextInt(fieldSizeX);
            coordinate[1] = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(coordinate[0], coordinate[1]));

        field[coordinate[0]][coordinate[1]] = DOT_AI;
        return new int[]{coordinate[0], coordinate[1]};
    }

    private static int[] forecastCheckWin(char c, int winCount) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    field[i][j] = c;
                    if (checkWin(c, winCount)) {
                        field[i][j] = DOT_EMPTY;
                        return new int[]{i, j};
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return null;
    }

    private static boolean checkWin(char c, int winCount) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (rightWinCheck(i, j, c, winCount))     return true;
                if (downWinCheck(i, j, c, winCount))      return true;
                if (rightUpWinCheck(i, j, c, winCount))   return true;
                if (rightDownWinCheck(i, j, c, winCount)) return true;
            }
        }
        return false;
    }
}
