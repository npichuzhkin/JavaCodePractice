package com.npichuzhkin.javacodepractice.javaconcurrency.topic20;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {
    private final CyclicBarrier cyclicBarrier;
    private ExecutorService executor;

    public ComplexTaskExecutor(int parties){
        cyclicBarrier = new CyclicBarrier(parties, () -> {
            System.out.println("Complex task has been completed");
        });
    }

    public void executeTasks(int numberOfTasks) {
        executor = Executors.newFixedThreadPool(numberOfTasks);
        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(() -> {
                ComplexTask task = new ComplexTask();
                task.execute();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
