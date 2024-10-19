package com.npichuzhkin.javacodepractice.javastreamapi.topic10;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private long factorialValue;

    public FactorialTask(long factorialValue){
        this.factorialValue = factorialValue;
    }
    @Override
    protected Long compute() {
        if (factorialValue <= 1) return 1L;

        FactorialTask subTask = new FactorialTask(factorialValue - 1L);
        subTask.fork();

        return factorialValue * subTask.join();
    }
}
