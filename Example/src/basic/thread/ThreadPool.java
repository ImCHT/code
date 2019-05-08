package basic.thread;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args){
        new ThreadPool().threadPoolExecutor();

    }

    /**
     * ͨ��ThreadPoolExecutor�����̳߳�
     */
    void threadPoolExecutor(){
        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(512);
        RejectedExecutionHandler policy = new ThreadPoolExecutor.DiscardPolicy();
        ExecutorService executorService = new ThreadPoolExecutor(poolSize, poolSize,
                0, TimeUnit.SECONDS,
                queue,
                policy);
        for(int i = 0;i < 7;i++ ) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("��" +index +"���߳�" +Thread.currentThread().getName());
                }
            });
        }
    }

    /**
     * ͨ��Executors����CachedThreadPool
     * һ���߳������������̳߳أ�����������߳���ΪInteger.MAX_VALUE��������Ǻܴ�ģ�һ���ɻ����̳߳أ�
     * ����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳������̳߳��еĿ����̶߳�
     * �г�ʱ���ƣ������ʱʱ����60�룬����60�������߳̾ͻᱻ���ա�
     * �����̳߳رȽ��ʺ�ִ�д����ĺ�ʱ���ٵ����񣬵������̳߳ض���������״̬ʱ���̳߳��е��̶߳��ᳬʱ��ֹͣ��
     */
    void cachedThreadPool(){
        ExecutorService mCachelThreadPool = Executors.newCachedThreadPool();

        for(int i = 0;i < 7;i++ ) {
            final int index = i;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mCachelThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("��" +index +"���߳�" +Thread.currentThread().getName());
                }
            });
        }
    }

    /**
     * ͨ��Executors����FixedThreadPool
     * һ��ָ�������߳��������̳߳أ�ÿ���ύһ������ʹ���һ�������̣߳����߳� ���ڿ���״̬ʱ��
     * ���ǲ����ᱻ���գ������̳߳ر��ر��ˣ���������߳������ﵽ�̳߳س�ʼ������������ύ��
     * ������뵽�ض��У�û�д�С���ƣ��С�����newFixedThreadPoolֻ�к����̲߳�����Щ�����̲߳�
     * �ᱻ���գ����������ӿ��ٵ���Ӧ��������
     * �����߳���������߳�����ͬ
     */
    void fixedThreadPool(){
        //��������߳���5��
        ExecutorService mFixedThreadPool = Executors.newFixedThreadPool(5);

        for(int i = 0;i < 7;i++ ) {
            final int index = i;
            mFixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("ʱ����:"+System.currentTimeMillis()+"��" +index +"���߳�" +Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    /**
     * ͨ��Executors����ScheduledThreadPool
     * һ���̳߳أ����ĺ����߳������ǹ̶��ģ����Ǻ����߳�����û�����Ƶģ����ҵ��Ǻ����߳�����ʱ�ᱻ�������գ�
     * ���ɰ��Ÿ����ӳٺ�����������߶��ڵ�ִ�С������̳߳���Ҫ����ִ�ж�ʱ����;��й̶����ڵ��ظ�����
     */
    void scheduledThreadPool(){
        //���ó��к���������2
        ScheduledExecutorService mScheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("���ڵ�ʱ��:"+System.currentTimeMillis());
        mScheduledThreadPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("���ڵ�ʱ��:"+System.currentTimeMillis());

            }
        }, 2, 3, TimeUnit.SECONDS);//���������ӳ�2���ÿ3��ִ��һ��
    }

    /**
     * ͨ��Executors����SingleThreadPool
     * �����̳߳��ڲ�ֻ��һ�������̣߳����޽���з�ʽ��ִ�и��̣߳���ʹ����Щ����֮�䲻��Ҫ�����߳�ͬ�������⣬
     * ��ȷ�����е�������ͬһ���߳��а�˳����ִ�У����ҿ��������������ʱ�䲻���ж���߳��ǻ�ġ�
     */
    void singleThreadPool(){
        ExecutorService mSingleThreadPool = Executors.newSingleThreadExecutor();
        for(int i = 0;i < 7;i++) {
            final int number = i;
            mSingleThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("���ڵ�ʱ��:"+System.currentTimeMillis()+"��"+number+"���߳�");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
