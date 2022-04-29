package concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author Melody
 * @date 2022/4/29 11:01
 */
public class ConsumerAndProducer {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        ConsumerAndProducer cap = new ConsumerAndProducer();
        Thread producer = new Thread(cap.new Producer());
        Consumer consumer = cap.new Consumer();
        consumer.start();
        producer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        public void consume() {
            while (true) {
                try {
                    queue.take();
                    System.out.println("从队列中取走一个元素，队列剩余" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            produce();
        }

        public void produce() {
            while (true) {
                try {
                    Random random = new Random();
                    queue.put(random.nextInt());
                    System.out.println("向队列中插入一个元素，队列剩余空间" + (queueSize - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
Lock
}
