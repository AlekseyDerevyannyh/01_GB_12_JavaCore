package ru.gb.hw5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Program {

    public static final String BACKUP_DIR="/backup";

    public static void main(String[] args) {
        backupAllFilesInDir("C:/Data/tmp1");
    }

    /**
     * Метод, создающий резервную копию всех файлов в директории (без поддиректорий)
     * во вновь созданную папку ./backup
     * @param path - путь до директории для бэкапа
     */
    public static void backupAllFilesInDir(String path) {
        File file = new File(path);
        File[] files = file.listFiles();

        if (files == null) {
            System.out.println("Путь не найден!");
            return;
        }

        if (files.length == 0) {
            System.out.println("Папка пуста! Нет файлов для резервного копирования!");
        }

        File backupDir = new File(path + BACKUP_DIR);
        if (!backupDir.exists()) {
            if (!backupDir.mkdir()) {
                System.out.printf("Ошибка создания папки '%s'!\n", BACKUP_DIR);
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
}
