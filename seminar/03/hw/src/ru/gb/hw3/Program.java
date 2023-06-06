package ru.gb.hw3;

import ru.gb.hw3.modules.Repository;
import ru.gb.hw3.modules.Worker;
import ru.gb.hw3.modules.FixedPayWorker;
import ru.gb.hw3.modules.HourlyPayWorker;

import java.util.ArrayList;
import java.util.Collections;

public class Program {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new HourlyPayWorker("Petr",500.8932));
        workers.add(new FixedPayWorker("Ivan",80000.389));
        workers.add(new HourlyPayWorker("Aleksey",600.589));
        workers.add(new FixedPayWorker("Aleksandr",70000.5923));

        Collections.sort(workers);

        Repository repository = new Repository(workers);
        repository.add(new FixedPayWorker("Yaroslav", 60000.0));
        repository.printAll();
    }
}
