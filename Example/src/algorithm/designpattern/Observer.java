package algorithm.designpattern;

import java.util.ArrayList;
import java.util.Observable;

/*
    观察者模式：主题+观察者 = 观察者模式
    概念：主题有数据，有更新时会通知订阅该主题的观察者，使他们做出相应的反映。
          观察者可以自行订阅或者退订相应的主题，订阅的话，主题改变时就会受到通知，做出预定的反应。
    原理：主题维持了一个订阅者列表，数据更新时，会遍历列表，调用每一个订阅该主题的观察者预定的反应方法
    应用场景：jdk的util包里面定义了主题Observable和观察者接口Observe。报纸，杂志等等
 */
public class Observer {
    //测试jdk实现的观察者模式
    public static void main(String[] args){
       JdkSubject jdkSubject = new JdkSubject();
       JdkObserve jdkObserve1 = new JdkObserve(jdkSubject);
       JdkObserve jdkObserve2 = new JdkObserve(jdkSubject);
       jdkSubject.changeAndNotifyPull("鬼子来了！","跟他干！");
       jdkSubject.changeAndNotifyPush("小鬼，","快过来玩啊！");
    }
    //测试自定义的观察者
//    public static void main(String[] args){
//        ConcreteSubject concreteSubject = new ConcreteSubject();
//        Observerable observer1 = new Observer1(concreteSubject);
//        Observerable observer2 = new Observer2(concreteSubject);
//        concreteSubject.setMessage1("鬼子来了！");
//        concreteSubject.setMessage2("快跑啊！");
//        concreteSubject.notifyObservers();
//    }
}
/*
    java.util.Observable和Observe，实现观察者模式
    注意调用notifyObservers方法时需要设置setChanged
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
    //让观察者以拉的方式获取数据
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
        //以拉的方式获取数据
        if (arg==null){
            if (o instanceof JdkSubject){
                JdkSubject jdkSubject = (JdkSubject)o;
                System.out.println(jdkSubject.getMessage1()+jdkSubject.getMessage2());
            }
        }else { //以推的方式获取数据
            if (arg instanceof String[]){
                String[] message = (String[])arg;
                System.out.println(message[0]+message[1]);
            }
        }

    }
}


/*
    自定义的观察者模式
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