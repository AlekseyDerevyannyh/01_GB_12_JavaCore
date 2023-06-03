package ru.gb.hw3.modules;

public class hourlyPayWorker extends Worker {
    private double hourlyRate;

    @Override
    double avgMonthlySalary() {
        return (double) Math.round(20.8 * 8 * this.hourlyRate * 100) / 100;
    }
}
