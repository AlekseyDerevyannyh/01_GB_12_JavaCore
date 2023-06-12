package ru.geekbrains.lesson4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Program {

    public static void main(String[] args) throws AnimalRunException, AnimalSwimException {

        /*try {
            int[] numbers = new int[3];
            numbers[3] = 45;
            System.out.println(numbers[3]);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }*/

        //try{}catch{}
        //try{}catch{}finally{}
        //try{}finally{}

        //readTextFile("C://test//forTest.txt", true);

        Animal cat = new Cat("Персик", 100);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int j = random.nextInt(2);
            try
            {
                switch (j){
                    case 0:
                        cat.swim(i*10);
                        break;
                    case 1:
                        cat.run(i*10);
                        System.out.printf("Кошка пробежала %d метров\n", i*10);
                        break;
                }
            }
            catch (AnimalRunException ex){
                System.out.printf("Ошибка при попытке %s пробежать %d метров\n%s\n",
                        ex.getName(), ex.getDistance(), ex.getMessage());
            }
            catch (AnimalSwimException ex){
                System.out.printf("Ошибка при попытке %s проплыть %d метров\n%s\n",
                        ex.getName(), ex.getDistance(), ex.getMessage());
            }
        }
    }

    public static void readTextFile(String fileName, boolean f){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            char[] buf = new char[256];
            int c;
            while ((c = fileReader.read(buf)) > 0){
                if (f){
                    throw new Exception("Неожиданное исключение.");
                }
                if (c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                for (char symbol : buf) {
                    System.out.print(symbol);
                }
            }
            fileReader.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("*** Проблема при открытии файла ***");
        }
        catch (IOException ex){
            System.out.println("*** Проблема при работе с файлом ***");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            }
            catch (IOException e){

            }
        }
    }


}
