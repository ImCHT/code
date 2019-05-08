package basic.lock;
//线程thread1先获取锁locka，然后在同步块里嵌套竞争锁lockb。而线程thread2先获取锁lockb，然后在同步块里嵌套竞争锁locka
public class SyncDeadLock {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args){
        new SyncDeadLock().deadLock();
    }

    private void deadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    try{
                        System.out.println(Thread.currentThread().getName()+" get lockA!");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName()+" after sleep 500ms!");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" need lockB!Just waiting!");
                    synchronized (lockB){
                        System.out.println(Thread.currentThread().getName()+" get lockB!");
                    }
                }
            }
        },"线程1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB){
                    System.out.println(Thread.currentThread().getName()+" get lockB!");
                    try {
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName()+" after sleep 500ms!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" need locaA!Just Wating!");
                    synchronized (lockA){
                        System.out.println(Thread.currentThread().getName()+" get lockA!");
                    }
                }
            }
        },"线程2");

        thread1.start();
        thread2.start();
    }
}
