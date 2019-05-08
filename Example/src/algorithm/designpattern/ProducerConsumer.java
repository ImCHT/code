package algorithm.designpattern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/*
    ������������ģʽ
    �������ã������߲�����Ϣ��������������Ϣ���������������Զ�����������Ϣ��ʱ����Ƶ��
    ԭ���������Ը�concurrent���е�����������ʵ�������ߺ�������֮��Ľ�����ArrayBlockingQueue��
    ʹ�ó������ڿͻ��˴��ڸ߲�������ʱ�������Ƚ�����ŵ����������У���ֹ��������ѹ���������
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
