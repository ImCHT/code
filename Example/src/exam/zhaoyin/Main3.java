package exam.zhaoyin;

/*
    10%
    ��Ŀ������
    ��nƿ��ѧ�Լ�����iƿ��ai�����Լ���Ҫ��ÿһƿ���Լ������
    ���Խ���һ�����ֲ�����
    1. ���Լ�������
    2. ���Լ�������
    �����Լ���������������ٽ��м��β�������������ƿ�е��Լ��������
    ���룺
    ��һ��Ϊһ������n��
    �ڶ���Ϊn������ai
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
        //���Ƿ�֮����2�ı�����ϵ���ǵĻ����
        //�����м䣬�ֳ�������
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
        //����
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
