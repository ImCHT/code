package com.nowcoder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MultiThread {
    private static Object lock = new Object();
    private static void synchronized1(){
        synchronized (lock){
            try {
                for (int j = 0; j < 10; j++) {
                    Thread.sleep(1000);
                    System.out.println(String.format("synchronized1:%d",j));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static void synchronized2(){
        synchronized (lock){
            try {
                for (int j = 0; j < 10; j++) {
                    Thread.sleep(1000);
                    System.out.println(String.format("synchronized2:%d",j));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void testBlockingQueue(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
    }

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void testThreadLocal(){
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        threadLocal.set(finalI);
                        Thread.sleep(1000);
                        System.out.println(threadLocal.get());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args){
//        synchronized1();
//        synchronized2();
//        testBlockingQueue();
        testThreadLocal();
    }
}

class Consumer implements Runnable{
    private BlockingQueue<String> blockingQueue;
    public Consumer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+blockingQueue.take());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
    private BlockingQueue<String> blockingQueue;
    public Producer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(1000);
                blockingQueue.put(String.valueOf(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    private int tid;
    MyThread(int tid){
        this.tid = tid;
    }

    @Override
    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(String.format("%d:%d",tid,i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
