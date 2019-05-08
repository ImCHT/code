package basic.thread;

import sun.misc.Unsafe;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);

        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(callable1);
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(callable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(futureTask1);
        executor.execute(futureTask2);

        while (true){
            try{
                if (futureTask1.isDone() && futureTask2.isDone()){
                    System.out.println("done");
                    System.out.println("FutureTaks1="+futureTask1.get());
                    System.out.println("FutureTask2="+futureTask2.get());
                    executor.shutdown();
                    return;
                }
                //会阻塞在这里等到call方法结果返回
                System.out.println("FutureTaks1="+futureTask1.get());
                System.out.println("FutureTask2="+futureTask2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
