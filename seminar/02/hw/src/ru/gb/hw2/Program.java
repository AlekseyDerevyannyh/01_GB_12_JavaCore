package ru.gb.hw2;

public class Program {
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = ' ';
    private static char[][] field;

    private static final int fieldSizeX = 7;
    private static final int fieldSizeY = 4;

    public static void main(String[] args) {
        initialize();
        printField();
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
}
