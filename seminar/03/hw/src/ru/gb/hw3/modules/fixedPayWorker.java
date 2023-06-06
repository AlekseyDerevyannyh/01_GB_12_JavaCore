package ru.gb.hw3.modules;

public class fixedPayWorker extends Worker {
    private double monthlySalary;       // месячная зарплата

    public fixedPayWorker(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = (double) Math.round(monthlySalary * 100) / 100; // округляем зарплату до двух знаков после запятой
    }

    @Override
    double avgMonthlySalary() {
        return monthlySalary;
    }

//    @Override
//    public int compare(Worker o1, Worker o2) {
//        return o1.getFirstName().compareTo(o2.getFirstName());
//    }

    @Override
    public String toString() {
        return "fixedPayWorker{" +
                "Name=" + name +
                ", monthlySalary='" + monthlySalary + '\'' +
                '}';
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}