package ru.gb.hw3;

import ru.gb.hw3.modules.Worker;
import ru.gb.hw3.modules.fixedPayWorker;
import ru.gb.hw3.modules.hourlyPayWorker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new hourlyPayWorker("Petr",500.8932));
        workers.add(new fixedPayWorker("Ivan",80000.389));
//        workers.sort(Comparator.comparing(Worker::getFirstName));
        Collections.sort(workers);
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }
}
