package ru.gb.hw3;

import ru.gb.hw3.modules.Worker;
import ru.gb.hw3.modules.fixedPayWorker;
import ru.gb.hw3.modules.hourlyPayWorker;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new fixedPayWorker("Ivan", "Ivanov", 80000.0));
        workers.add(new hourlyPayWorker("Petr", "Petrov", 500.0));
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }
}
