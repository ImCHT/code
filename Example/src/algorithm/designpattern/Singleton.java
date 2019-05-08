package algorithm.designpattern;

/*
    单例模式：私有化单例静态变量，私有化构造函数，公有化获取单例对象的方法
    概念作用：确保一个类只有一个实例，并提供一个全局访问点
              多次获取此类的对象时，获取到的为同一个对象。很多情况下，不需要也不应该有多个对象时，单例模式就有用了。
              避免程序行为异常，资源使用过量或是不一致的情况
    使用场景：线程池，缓存，对话框，注册表设置。
    方式：饿汉式
          懒汉式的双重检查版本，内部类式，枚举式
    懒汉式
    没有synchronize的版本，单判断：线程不安全，两个线程进入if判断之后会创建两个实例对象
    有synchronize的版本，单判断：线程安全，但每一次获取单例对象的时候都需要加锁，效率太低
    有synchronize的版本，双重判断，没volatile：线程安全，但由于代码重排序，可能存在分配了空间，却没有实例化对象的情况，
                                               这样就会造成返回了实例对象却并没有实例化的情况
    有volatile关键字的双重检查：可以了
    静态内部类方式及内部类式可能在实际工作中用的更多
 */
/*
1. 构造函数私有化
2. public静态获取单例的方法
3. 静态私有化单例
懒汉式
饿汉式
 */
//1. 饿汉式
//public class Singleton {
//    private Singleton(){};
//    private static Singleton singleton = new Singleton();
//    public static Singleton getInstance(){
//        return singleton;
//    }
//}

//2. 懒汉式，没有考虑多线程问题
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

//3. 懒汉式，双重检查版本
//使用 volatile 有两个功用：
//1）这个变量不会在多个线程中存在复本，直接从内存读取。
//2）这个关键字会禁止指令重排序优化。也就是说，在 volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），读操作不会被重排序到内存屏障之前。
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

//4. 基于静态内部类初始化的解决方案
//public class Singleton{
//    private static class InstanceHolder{
//        public static Singleton instance = new Singleton();
//    }
//    public static Singleton getInstance(){
//        return InstanceHolder.instance;
//    }
//}

//5. 枚举法实现单例模式
public enum Singleton{
    INSTANCE;
    public static Singleton getInstance(){
        return INSTANCE;
    }
}

