package algorithm.designpattern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/*
    生产者消费者模式
    概念作用：生产者产生信息，消费者消费信息。可以让消费者自动控制消费信息的时机和频率
    原理：可以用以个concurrent包中的阻塞队列来实现生产者和消费者之间的交互。ArrayBlockingQueue。
    使用场景：在客户端处于高并发请求时，可以先将请求放到阻塞队列中，防止过多请求压垮服务器。
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce..");
        }
    }

    private static class Consumer extends Thread {

        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume..");
        }
    }
}
