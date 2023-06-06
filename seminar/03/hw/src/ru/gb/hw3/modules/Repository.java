package ru.gb.hw3.modules;

import java.util.ArrayList;

public class Repository {
    ArrayList<Worker> workers;

    public Repository() {
        this.workers = new ArrayList<>();
    }
    public Repository(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public void add(Worker worker) {
        this.workers.add(worker);
    }

    public ArrayList<Worker> getAll() {
        return this.workers;
    }

    public void printAll() {
        for (Worker worker : this.workers) {
            System.out.println(worker);
        }
    }
}
