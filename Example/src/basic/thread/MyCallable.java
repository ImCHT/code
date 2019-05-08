package basic.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{
    private long waitTime;
    public MyCallable(int time){
       this.waitTime = time;
    }
    @Override
    public Integer call() throws Exception {
        Thread.sleep(waitTime);
        int result = 1+2;
        return result;
    }
}
