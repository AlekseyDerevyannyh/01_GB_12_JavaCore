package ru.gb.hw3.modules;

public abstract class Worker implements Comparable<Worker> {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    abstract double avgMonthlySalary();     // расчёт среднемесячной зарплаты

    @Override
    public int compareTo(Worker worker) {
        if (this.name.compareTo(worker.getName()) > 0)
            return 1;
        else if (this.name.compareTo(worker.getName()) < 0)
            return -1;
        else
            return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
