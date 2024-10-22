package com.npichuzhkin.javacodepractice.javaconcurrency.topic5;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException{
        BlockingQueue queue = new BlockingQueue();

        Thread producer = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(100);
                    queue.enqueue();
                } catch (InterruptedException e) {
                    System.out.println("Producer has been finished");
                    break;
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(200);
                    queue.dequeue();
                } catch (InterruptedException e) {
                    System.out.println("Consumer has been finished");
                    break;
                }
            }
        });

        producer.start();
        consumer.start();

        Thread.sleep(3500);

        producer.interrupt();
        consumer.interrupt();

    }
}
