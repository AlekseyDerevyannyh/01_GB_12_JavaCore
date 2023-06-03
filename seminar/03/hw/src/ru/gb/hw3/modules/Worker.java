package ru.gb.hw3.modules;

public abstract class Worker {
    protected String firstName;
    protected String lastName;

    public Worker(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    abstract double avgMonthlySalary();     // расчёт среднемесячной зарплаты

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
