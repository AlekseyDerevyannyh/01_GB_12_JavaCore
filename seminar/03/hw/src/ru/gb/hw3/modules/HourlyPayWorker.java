package ru.gb.hw3.modules;

public class HourlyPayWorker extends Worker {
    private double hourlyRate;      // почасовая ставка

    public HourlyPayWorker(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = (double) Math.round(hourlyRate * 100) / 100;  // округляем часовую ставку до 2х знаков после запятой
    }

    @Override
    double avgMonthlySalary() {
        return (double) Math.round(20.8 * 8 * this.hourlyRate * 100) / 100;
    }

    @Override
    public String toString() {
        return "HourlyPayWorker{" +
                "Name=" + super.getName() +
                ", HourlyRate='" + hourlyRate + '\'' +
                ", Salary='" + this.avgMonthlySalary() + '\'' +
                '}';
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
