package ru.gb.hw4;

public class Program {

    public static void main(String[] args) {
        String[][] array = new String[][]{  {"1", "2", "3", "4"},
                                            {"1", "2", "3", "4"},
                                            {"1", "2", "f", "4"},
                                            {"1", "2", "3", "4"}};

        int result = 0;
        try {
            result = sumStringArray(array);
            System.out.printf("Сумма всех элементов массива равна: %d", result);
        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (MyArrayDataException ex) {
            System.out.printf("ОШИБКА! Невозможно преобразовать данные в int в ячейке [%d][%d].\n%s\n", ex.getRow(), ex.getColumn(), ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static int sumStringArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("ОШИБКА! Размерность массива не равна 4х4!");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("ОШИБКА! Размерность массива не равна 4х4!");
            }
        }

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(e.getMessage(), i, j);
                }
            }
        }
        return result;
    }
}
