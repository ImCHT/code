package basic.thread;

import java.util.ArrayList;
import java.util.ListIterator;

public class ThreadLocal {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        ListIterator listIterator = list.listIterator();
        java.lang.ThreadLocal threadLocal = new java.lang.ThreadLocal();
        threadLocal.set(1);
        java.lang.ThreadLocal threadLoca2 = new java.lang.ThreadLocal();
        threadLoca2.set(2);
        System.out.println(threadLocal.get());
        System.out.println(threadLoca2.get());
    }
}
