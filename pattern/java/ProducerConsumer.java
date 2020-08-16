import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumer {
    private final Queue<Integer> queue;
    private final Object lock = new Object();
    private final int capacity;
    private int taskNum = 0;

    ProducerConsumer(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {
            while (true) {
                synchronized (lock) {
                    while (queue.size() == capacity) {
                        lock.wait();
                    }
                    queue.add(taskNum);
                    System.out.println("+++produce:" + taskNum++);
                    lock.notifyAll();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            while (true) {
                synchronized (lock) {
                    while (queue.size() == 0) {
                        lock.wait();
                    }
                    Integer task = queue.poll();
                    System.out.println("---consume:" + task);
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer(10);
        Consumer consumer = pc.new Consumer();
        Producer producer = pc.new Producer();
        consumer.start();
        producer.start();
    }
}
