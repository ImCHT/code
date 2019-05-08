package algorithm.designpattern;

/*
    ����ģʽ��˽�л�������̬������˽�л����캯�������л���ȡ��������ķ���
    �������ã�ȷ��һ����ֻ��һ��ʵ�������ṩһ��ȫ�ַ��ʵ�
              ��λ�ȡ����Ķ���ʱ����ȡ����Ϊͬһ�����󡣺ܶ�����£�����ҪҲ��Ӧ���ж������ʱ������ģʽ�������ˡ�
              ���������Ϊ�쳣����Դʹ�ù������ǲ�һ�µ����
    ʹ�ó������̳߳أ����棬�Ի���ע������á�
    ��ʽ������ʽ
          ����ʽ��˫�ؼ��汾���ڲ���ʽ��ö��ʽ
    ����ʽ
    û��synchronize�İ汾�����жϣ��̲߳���ȫ�������߳̽���if�ж�֮��ᴴ������ʵ������
    ��synchronize�İ汾�����жϣ��̰߳�ȫ����ÿһ�λ�ȡ���������ʱ����Ҫ������Ч��̫��
    ��synchronize�İ汾��˫���жϣ�ûvolatile���̰߳�ȫ�������ڴ��������򣬿��ܴ��ڷ����˿ռ䣬ȴû��ʵ��������������
                                               �����ͻ���ɷ�����ʵ������ȴ��û��ʵ���������
    ��volatile�ؼ��ֵ�˫�ؼ�飺������
    ��̬�ڲ��෽ʽ���ڲ���ʽ������ʵ�ʹ������õĸ���
 */
/*
1. ���캯��˽�л�
2. public��̬��ȡ�����ķ���
3. ��̬˽�л�����
����ʽ
����ʽ
 */
//1. ����ʽ
//public class Singleton {
//    private Singleton(){};
//    private static Singleton singleton = new Singleton();
//    public static Singleton getInstance(){
//        return singleton;
//    }
//}

//2. ����ʽ��û�п��Ƕ��߳�����
//public class Singleton{
//    private static Singleton singleton = null;
//    private Singleton(){};
//
//    public static Singleton getInstance() {
//        if(singleton==null){
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
//}

//3. ����ʽ��˫�ؼ��汾
//ʹ�� volatile ���������ã�
//1��������������ڶ���߳��д��ڸ�����ֱ�Ӵ��ڴ��ȡ��
//2������ؼ��ֻ��ָֹ���������Ż���Ҳ����˵���� volatile �����ĸ�ֵ�����������һ���ڴ����ϣ����ɵĻ������ϣ������������ᱻ�������ڴ�����֮ǰ��
//public class Singleton{
//    private static volatile Singleton singleton = null;
//    private Singleton(){};
//    public static Singleton getInstance(){
//        if(singleton==null){
//            synchronized (Singleton.class){
//                if (singleton==null){
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}

//4. ���ھ�̬�ڲ����ʼ���Ľ������
//public class Singleton{
//    private static class InstanceHolder{
//        public static Singleton instance = new Singleton();
//    }
//    public static Singleton getInstance(){
//        return InstanceHolder.instance;
//    }
//}

//5. ö�ٷ�ʵ�ֵ���ģʽ
public enum Singleton{
    INSTANCE;
    public static Singleton getInstance(){
        return INSTANCE;
    }
}

