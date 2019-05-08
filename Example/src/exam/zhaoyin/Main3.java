package exam.zhaoyin;

/*
    10%
    题目描述：
    有n瓶化学试剂，第i瓶有ai升的试剂，要让每一瓶的试剂量相等
    可以进行一下两种操作：
    1. 将试剂量翻倍
    2. 将试剂量减半
    假设试剂容量无穷大，问至少进行几次操作才能让所有瓶中的试剂含量相等
    输入：
    第一行为一个整数n，
    第二行为n个整数ai
 */
import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long[] a = new long[(int)n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        int result = 0;
        boolean flag = true;
        //看是否之间是2的倍数关系，是的话输出
        //根据中间，分成两部分
        for (int i = 0; i < a.length/2; i++) {
            if (n2(a[i],a[a.length/2])==-1){
                flag = false;
                break;
            }else {
                result += n2(a[i],a[a.length/2]);
            }
        }
        for (int i = a.length/2+1; i < a.length; i++) {
            if (n2(a[a.length/2],a[i])==-1){
                flag = false;
                break;
            }else {
                result += n2(a.length/2,a[i]);
            }
        }
//        for (int i = 1; i < a.length; i++) {
//            if (n2(a[0],a[i])==-1){
//                flag = false;
//                break;
//            }else {
//                result += n2(a[0],a[i]);
//            }
//        }
        if (flag){
            System.out.println(result);
            return;
        }
        //否则
        result = 0;
        for (int i = 0; i < a.length; i++) {
            result+=n1(a[i]);
        }
        System.out.println(result);
    }
    public static int n2(long base,long ji){
        for (int i = 0; i < 1000; i++) {
            if((int)(base*Math.pow(2,i+1))==ji){
                return i+1;
            }
        }
        return -1;
    }
    public static int n1(long base){
        int num = 0;
        while (base!=1){
            base = base/2;
            num++;
        }
        return num;
    }
}
