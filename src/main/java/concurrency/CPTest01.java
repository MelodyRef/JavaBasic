package concurrency;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Melody
 * @date 2021/8/17 15:58
 */
public class CPTest01 {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

    public static void main(String[] args) {
        CPTest01 test = new CPTest01();
        Consumer consumer = test.new Consumer();
        Producer producer = test.new Producer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    queue.take();
                    System.out.println("take an element from queue,rest:" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(1);
                    System.out.println("insert an element into queue,rest:" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


