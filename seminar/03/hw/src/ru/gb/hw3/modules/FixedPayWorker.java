package ru.gb.hw3.modules;

public class FixedPayWorker extends Worker {
    private double monthlySalary;       // месячная зарплата

    public FixedPayWorker(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = (double) Math.round(monthlySalary * 100) / 100; // округляем зарплату до двух знаков после запятой
    }

    @Override
    double avgMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "FixedPayWorker{" +
                "Name=" + super.getName() +
                ", MonthlySalary='" + monthlySalary + '\'' +
                ", Salary='" + this.avgMonthlySalary() + '\'' +
                '}';
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}