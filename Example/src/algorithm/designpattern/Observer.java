package algorithm.designpattern;

import java.util.ArrayList;
import java.util.Observable;

/*
    �۲���ģʽ������+�۲��� = �۲���ģʽ
    ������������ݣ��и���ʱ��֪ͨ���ĸ�����Ĺ۲��ߣ�ʹ����������Ӧ�ķ�ӳ��
          �۲��߿������ж��Ļ����˶���Ӧ�����⣬���ĵĻ�������ı�ʱ�ͻ��ܵ�֪ͨ������Ԥ���ķ�Ӧ��
    ԭ������ά����һ���������б����ݸ���ʱ��������б�����ÿһ�����ĸ�����Ĺ۲���Ԥ���ķ�Ӧ����
    Ӧ�ó�����jdk��util�����涨��������Observable�͹۲��߽ӿ�Observe����ֽ����־�ȵ�
 */
public class Observer {
    //����jdkʵ�ֵĹ۲���ģʽ
    public static void main(String[] args){
       JdkSubject jdkSubject = new JdkSubject();
       JdkObserve jdkObserve1 = new JdkObserve(jdkSubject);
       JdkObserve jdkObserve2 = new JdkObserve(jdkSubject);
       jdkSubject.changeAndNotifyPull("�������ˣ�","�����ɣ�");
       jdkSubject.changeAndNotifyPush("С��","������氡��");
    }
    //�����Զ���Ĺ۲���
//    public static void main(String[] args){
//        ConcreteSubject concreteSubject = new ConcreteSubject();
//        Observerable observer1 = new Observer1(concreteSubject);
//        Observerable observer2 = new Observer2(concreteSubject);
//        concreteSubject.setMessage1("�������ˣ�");
//        concreteSubject.setMessage2("���ܰ���");
//        concreteSubject.notifyObservers();
//    }
}
/*
    java.util.Observable��Observe��ʵ�ֹ۲���ģʽ
    ע�����notifyObservers����ʱ��Ҫ����setChanged
 */
class JdkSubject extends Observable{
    private String[] message = {"",""};
    private String message1;
    private String message2;

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
    //�ù۲��������ķ�ʽ��ȡ����
    public void changeAndNotifyPull(String message1, String message2){
        this.message1 = message1;
        this.message2 = message2;
        this.setChanged();
        notifyObservers();
    }

    public void changeAndNotifyPush(String message1, String message2){
        message[0] = message1;
        message[1] = message2;
        this.setChanged();
        notifyObservers(message);
    }

}
class JdkObserve implements java.util.Observer{
    Observable observable;
    public JdkObserve(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        //�����ķ�ʽ��ȡ����
        if (arg==null){
            if (o instanceof JdkSubject){
                JdkSubject jdkSubject = (JdkSubject)o;
                System.out.println(jdkSubject.getMessage1()+jdkSubject.getMessage2());
            }
        }else { //���Ƶķ�ʽ��ȡ����
            if (arg instanceof String[]){
                String[] message = (String[])arg;
                System.out.println(message[0]+message[1]);
            }
        }

    }
}


/*
    �Զ���Ĺ۲���ģʽ
 */
interface Subject{
    public void registerObserver(Observerable observerable);
    public void removeObserver(Observerable observerable);
    public void notifyObservers();
}

interface Observerable{
//    public void update();
    public void update(String... args);
}

class ConcreteSubject implements Subject{
    private ArrayList<Observerable> observers = new ArrayList<>();

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    private String message1;
    private String message2;
    @Override
    public void registerObserver(Observerable observerable) {
        observers.add(observerable);
    }

    @Override
    public void removeObserver(Observerable observerable) {
        observers.remove(observerable);
    }

    @Override
    public void notifyObservers() {
        for (Observerable observer:observers) {
            observer.update(message1,message2);
        }
    }
}

class Observer1 implements Observerable{
    private Subject subject;
    public Observer1(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }
//    @Override
//    public void update() {
//        System.out.println();
//    }

    public void update(String... args){
        for (String arg:args) {
            System.out.println(arg+" ");
        }
    }
}

class Observer2 implements Observerable{
//    @Override
//    public void update() {
//
//    }
    private Subject subject;
    public Observer2(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }
    public void update(String... args){
        for (String arg:args) {
            System.out.println(arg+"+");
        }
    }
}