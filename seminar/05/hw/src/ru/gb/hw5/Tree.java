package ru.gb.hw5;

import java.io.File;

public class Tree {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Метод распечатки дерева каталогов и файлов
     * Данный метод является рекурсивным, поэтому для его работы нужны дополнительные параметры
     * @param file - передаём объект File относительно которого будет рисоваться дерево каталогов и файлов
     * @param indent - отступ для текущей директории или файла (т.е. его графика)
     * @param isLast - флаг, обозначающий является ли данный каталог или файл последним в родительской папке
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent); // рисуем отступ
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        if (file.isDirectory())
            System.out.println(ANSI_BLUE + " [" + file.getName() + "]" + ANSI_RESET);
        else
            System.out.println(ANSI_GREEN + " " + file.getName() + ANSI_RESET);

        File[] files = file.listFiles();
        if (files == null)
            return;

        for (int i = 0; i < files.length; i++) {
            print(files[i], indent, i == files.length - 1);
        }
    }
}
