package ru.gb.hw3;

public class MyArrayDataException extends Exception {
    private final int row;
    private final int column;
    public MyArrayDataException(String message, int row, int column) {
        super(message);
        this.row = row;
        this.column  = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
