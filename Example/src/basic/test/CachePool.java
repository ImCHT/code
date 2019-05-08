package basic.test;

import java.nio.ByteBuffer;

public class CachePool {
    public static void main(String[] args){
        ///new Integer(123) 与 Integer.valueOf(123)区别
        ///整数的缓存池大小为-128~127
        Integer a = new Integer(123);
        Integer b = new Integer(123);
        System.out.println(a==b);
        Integer c = Integer.valueOf(123);
        Integer d = Integer.valueOf(123);
        System.out.println(c==d);
        Boolean e = new Boolean(true);
        Boolean f = new Boolean(true);
        System.out.println(e==f);
        Boolean g = Boolean.valueOf(true);
        Boolean h = Boolean.valueOf(true);
        System.out.println(g==h);
        //intern，字符串常量池
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3 == s4);
        String[] strings = new String[1000000000];
        strings[0] = "1";
        for (int i = 1; i < strings.length; i++) {
            strings[i] = strings[i-1]+"1";
        }
    }
}
