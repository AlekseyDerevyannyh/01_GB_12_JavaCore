package ru.gb.hw3.modules;

public class fixedPayWorker extends Worker {
    private double monthlySalary;

    @Override
    double avgMonthlySalary() {
        return (double) Math.round(monthlySalary * 100) / 100;
    }
}