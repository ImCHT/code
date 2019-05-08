package basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �������ģʽ
 * ��̬����Ͷ�̬����
 */
public class DynamicProxy {

    //��̬����
//    public static void main(String[] args) {
//        //�������ѧ�����������İ���Ͻ��д������monitor���೤�����
//        Person zhangsan = new Student("����");
//
//        //���ɴ�����󣬲������������������
//        Person monitor = new StudentsProxy(zhangsan);
//
//        //�೤�����Ͻ����
//        monitor.giveMoney();
//    }

    //��̬����
    public static void main(String[] args) {

        //����һ��ʵ��������������Ǳ�����Ķ���
        Person zhangsan = new Student("����");

        //����һ�����������������InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);

        //����һ���������stuProxy������zhangsan����������ÿ��ִ�з��������滻ִ��Invocation�е�invoke����
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //����ִ���Ͻ���ѵķ���
        stuProxy.giveMoney();
    }
}
interface Person {
    //�Ͻ����
    void giveMoney();
}
class Student implements Person {
    private String name;
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        try {
            //������Ǯ����һ��ʱ��
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "�Ͻ����50Ԫ");
    }
}

/**
 * ͳ��ʱ��Ĺ�����
 */
class MonitorUtil {

    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //����ʱ��ӡ��ʱ
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "������ʱ" + (finishTime - tl.get()) + "ms");
    }
}

/**
 * ��̬������
 */
class StudentsProxy implements Person{
    //�������ѧ��
    Student stu;

    public StudentsProxy(Person stu) {
        // ֻ����ѧ������
        if(stu.getClass() == Student.class) {
            this.stu = (Student)stu;
        }
    }

    //�����Ͻ���ѣ����ñ�����ѧ�����Ͻ������Ϊ
    @Override
    public void giveMoney() {
        System.out.println("����֮ǰ");
        stu.giveMoney();
        System.out.println("����֮��");
    }
}

/**
 * ��̬������
 * @param <T>
 */
class StuInvocationHandler<T> implements InvocationHandler {
    //invocationHandler���еı��������
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * proxy:����̬�������
     * method����������ִ�еķ���
     * args���������Ŀ�귽��ʱ�����ʵ��
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("����ִ��" +method.getName() + "����");
        //��������в����ⷽ��,����÷�����ʱ
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}