package exam.ali;

/*
    4.13
    ��Ŀ������
    С����һ����ѧ�ң���ϲ�������ָ�����������ţ������Լ����Ϊ1��ͬʱ��2019��С��������һ��ũ����׼����ʼ��ĸ��
    ��ר�Ÿ�ũ����ĸ������������2��3��4��5��7��9��12��16��21��28��37��49��65��86��114��151...��������������ũ��
    ��ĸ����Զ��������Сĸ�������3�����죬�����ӵ����꿪ʼÿ��ֻ����һֻСĸ����һ��ũ������һֻ�ոճ�����С
    ĸ���һֻ�����ĸ��(���겻����С����һ�꿪ʼ��С��)���������Ǳ��Ϊ2��3�����ʣ���mֻĸ����Ϊ���٣�������һ
    ������ģ�С����׼����1�����ר�Ű��ũ����1��mֻ��ĸ��佱���佱��������:ѡ����1��mֻ��ĸ��ת���(114��ŷ�
    תΪ411)Ϊ��k���ĸ����а佱�������ǵڼ�ֻ��񽱣���ʾ: f(n)=f(n-2)+f(n-3)
    ����:
    ��������������Ƕ��ŷָ�
    m,k
    ���:
    ����������ְ�Ƕ��ŷָ�
    ��mֻĸ����,��һ�����,�ڼ�ֻС���
    ���뷶��:
    20,3
    �������:
    465,2024,15
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {

    /* ������������������ʵ����ĿҪ��Ĺ��� **/
    /* ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
    static String calculate(int m, int k) {
        return null;
    }
    //�����һֻ�������n��������������
    static int numOfPig1(int n){
       int[] num = new int[n];
       num[0] = 1;
       num[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            num[i] = num[i-1]+num[i-2];
        }
        return num[n];
    }
    //�տ�ʼһֻ��������n��������
    static int numOfPig2(int n){
        if (n<3){
            return 1;
        }else {
            return numOfPig1(n-3);
        }
    }
    //�ܵ�����:����������
    static int numOfPig3(int n){
        return numOfPig1(n)+numOfPig2(n);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}
