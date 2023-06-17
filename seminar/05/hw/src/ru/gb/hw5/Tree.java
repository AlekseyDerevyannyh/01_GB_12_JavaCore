package ru.gb.hw5;

import java.io.File;

public class Tree {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param file
     * @param indent
     * @param isLast
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
