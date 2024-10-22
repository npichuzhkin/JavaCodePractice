package com.npichuzhkin.javacodepractice.javaconcurrency.topic5;

public class SomeTask {

    private static long totalTasks;
    private long taskNumber;

    public SomeTask(){
        totalTasks++;
        taskNumber = totalTasks;
        System.out.println("Task number " + taskNumber + " created");
    }

    public long getTaskNumber(){
        return taskNumber;
    }
}
