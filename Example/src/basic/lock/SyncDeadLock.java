package basic.lock;
//�߳�thread1�Ȼ�ȡ��locka��Ȼ����ͬ������Ƕ�׾�����lockb�����߳�thread2�Ȼ�ȡ��lockb��Ȼ����ͬ������Ƕ�׾�����locka
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
        },"�߳�1");

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
        },"�߳�2");

        thread1.start();
        thread2.start();
    }
}
