package com.npichuzhkin.javacodepractice.javaconcurrency.topic5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue {
    private static final byte QUEUE_CAPACITY = 10;
    private final Object lock;
    private final Queue<SomeTask> queue;

    public BlockingQueue(){
        queue = new LinkedList<>();
        lock = new Object();
    }

    public void enqueue() throws InterruptedException {
        synchronized (lock){
            if (queue.size() >= QUEUE_CAPACITY) lock.wait();
            queue.add(new SomeTask());
            System.out.println("Queue size: " + queue.size() + "\n");
            lock.notify();
        }
    }

    public void dequeue() throws InterruptedException {
        synchronized (lock){
            if (queue.size() <= 0) lock.wait();
            lock.notify();
            System.out.println("Task number " + queue.poll().getTaskNumber() + " has been removed");
            System.out.println("Queue size: " + queue.size() + "\n");
        }
    }

    public int size(){
        return queue.size();
    }
}
