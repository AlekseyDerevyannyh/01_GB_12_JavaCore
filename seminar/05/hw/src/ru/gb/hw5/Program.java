package ru.gb.hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Program {

    public static final String BACKUP_DIR="/backup";

    public static void main(String[] args) {
        System.out.println("Задача 1");
        backupAllFilesInDir(".");

        System.out.println("\nЗадача 2");
        Tree.print(new File("."),  "", true);

        System.out.println("\nЗадача 3");
        int[] array = new int[]{3, 1, 3, 1, 1, 1, 3, 1, 3};
        byteArrayToFile("out.txt", intTo3Byte(arrayToInt(array)));
    }

    /**
     * Метод, создающий резервную копию всех файлов в директории (без поддиректорий)
     * во вновь созданную папку ./backup
     * @param path - путь до директории для бэкапа
     */
    public static void backupAllFilesInDir(String path) {
        File file = new File(path);
        File[] files = file.listFiles();

        System.out.printf("Backup started from folder '%s' to folder '.%s'\n", file.getPath(), BACKUP_DIR);
        if (files == null) {
            System.out.println("ERROR! Path not found!");
            return;
        }

        if (files.length == 0) {
            System.out.println("Folder is empty! No files to backup!");
        }

        File backupDir = new File(path + BACKUP_DIR);
        if (!backupDir.exists()) {
            if (!backupDir.mkdir()) {
                System.out.printf("Error creating folder '%s'!\n", BACKUP_DIR);
                return;
            }
        }
        for (File f : files) {
            File backupFile = new File(backupDir.getPath() + "/" + f.getName());
            if (f.isFile()) {
                try {
                    Files.copy(f.toPath(), backupFile.toPath(), REPLACE_EXISTING);
                    if (Files.exists(backupFile.toPath())) {
                        System.out.printf("Copy '%s' -> '%s'\t\tOK\n", f.getPath(), backupFile.getPath());
                    } else {
                        System.out.printf("Copy '%s' -> '%s'\t\tFAIL\n", f.getPath(), backupFile.getPath());
                    }
                } catch (IOException ex) {
                    System.out.printf("Copy '%s' -> '%s'\t\tFAIL\n", f.getPath(), backupFile.getPath());
                }
            }
        }
    }

    /**
     * Метод преобразования данных из числа типа int в массив из трёх байт
     * @param number - входное число
     * @return - возвращаемый массив из трёх байт
     */
    public static byte[] intTo3Byte(int number) {
        byte[] result = new byte[3];

        for (int i = 0; i < result.length; i ++) {
            result[i] = (byte) number;
            number >>= 8;
        }
        return result;
    }

    /**
     * Метод преобразования элементов массива из 9 элементов,
     * лежащих в диапазоне [0, 3] в одну переменную типа int
     * @param array - входной массив
     * @return - возврящаемое число типа int
     */
    public static int arrayToInt(int[] array) {
        if (!checkArray(array))
            return 0;

        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result <<= 2;
            result |= array[i];
        }
        return result;
    }

    /**
     * Метод проверки массива по условиям задачи
     * Длина массива должна быть равна 9
     * Элементы массива должны быть в диапазоне [0, 3]
     * @param array - проверяемый массив
     * @return - true, если массив удовлетворяет требованиям, false - в остальных случаях
     */
    public static boolean checkArray(int[] array) {
        if (array.length != 9) {
            System.out.println("Массив не удовлетворяет требованиям задачи - длина должна быть равна 9");
            return false;
        }
        for (int element : array) {
            if (element < 0 || element > 3) {
                System.out.println("Массив не удовлетворяет требованиям задачи - элементы массива должны быть в диапазоне [0, 3]");
                return false;
            }
        }
        return true;
    }

    /**
     * Метод записи в файл массива байт
     * @param filename - имя файла
     * @param array - входной массив
     */
    public static void byteArrayToFile(String filename, byte[] array) {
        File file = new File(filename);

        try (FileOutputStream outFile  = new FileOutputStream(file)) {
            outFile.write(array);
            System.out.printf("Bytes written to file '%s'\n", file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write date to file - " + file.getName());
        } catch (IOException e) {
            System.out.println("Error input/output: " + e);
        }
    }
}
