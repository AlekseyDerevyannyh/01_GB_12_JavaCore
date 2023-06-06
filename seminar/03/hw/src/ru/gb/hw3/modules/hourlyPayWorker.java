package ru.gb.hw3.modules;

public class hourlyPayWorker extends Worker {
    private double hourlyRate;      // почасовая ставка

    public hourlyPayWorker(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = (double) Math.round(hourlyRate * 100) / 100;  // округляем часовую ставку до 2х знаков после запятой
    }

    @Override
    double avgMonthlySalary() {
        return (double) Math.round(20.8 * 8 * this.hourlyRate * 100) / 100;
    }

//    @Override
//    public int compareTo(Worker o1, Worker o2) {
//        return o1.getName().compareTo(o2.getName());
//    }

    @Override
    public String toString() {
        return "hourlyPayWorker{" +
                "Name=" + name +
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
