package ru.gb.hw3.modules;

public class hourlyPayWorker extends Worker {
    private double hourlyRate;      // почасовая ставка

    public hourlyPayWorker(String firstName, String lastName, double hourlyRate) {
        super(firstName, lastName);
        this.hourlyRate = (double) Math.round(hourlyRate * 100) / 100;  // округляем часовую ставку до 2х знаков после запятой
    }

    @Override
    double avgMonthlySalary() {
        return (double) Math.round(20.8 * 8 * this.hourlyRate * 100) / 100;
    }

    @Override
    public String toString() {
        return "hourlyPayWorker{" +
                "firstName=" + firstName +
                ", lastName='" + lastName + '\'' +
                ", hourlyRate='" + hourlyRate + '\'' +
                '}';
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
