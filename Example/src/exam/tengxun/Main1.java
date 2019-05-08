package exam.tengxun;

import java.util.*;

/*
    4��5��
    ע��㣺
    1. ע����������ķ�Χ����int��������
 */
/**
 * û������
    ����������
    ��������
    ��һ������m,n��nΪӲ����ֵ������Ҫ�������ٵ�Ӳ�Ҳ�������ϳ�1��m������1��m��������ֵ
    ����n�У���ʾ��ֵ��
    �����С��ҪЯ����Ӳ����
    ˼·��
    //̰��
    ��һ�������Ӳ�ҵ���ֵΪ С�ڵ�����������ɵ���ֵ+1 �������ֵ��Ӳ��
 */
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] mianzhi = new int[n];
        int coinNum = 0;
        for (int i = 0; i < n; i++) {
            mianzhi[i] = scanner.nextInt();
        }
        System.out.println(oneToMMinNumOfCoin(mianzhi,m));

    }

    /**
     * ��������1~m������ֵ�������СӲ����
     * @param mianzhi
     * @param m
     * @return
     */
    static int oneToMMinNumOfCoin(int[] mianzhi,int m){
        Arrays.sort(mianzhi);
        //û����ֵΪ1��Ӳ�ң����-1
        if(mianzhi[0]!=1){
            return -1;
        }
        //����ָ��Ӳ����ֵ������
        int cur = 0;
        //��������ɵ���ֵ
        int now = 0;
        //���ڵ�Ӳ����
        int numOfCoin = 0;
        while (now<m){
            while (cur<mianzhi.length-1 && mianzhi[cur+1]<=now+1){
                cur++;
            }
            now += mianzhi[cur];
            numOfCoin++;
        }
        //��forѭ��
//        for (int i = 1; i <= m; i++) {
//            //���ڵ�Ӳ���㹻��
//            if(now>=i){
//                continue;
//            }else {     //Ӳ�Ҳ����������ܼ��������Ӳ��
//                while (cur<mianzhi.length-1 && mianzhi[cur+1]<=now+1){
//                    cur++;
//                }
//                now+=mianzhi[cur];
//                numOfCoin++;
//            }
//        }
        return numOfCoin;
    }

    /**
     * ��������m�������СӲ����������ĿҪ��һ��
     * @param mianzhi
     * @param m
     * @return
     */
    static int minNumOfCoin(int[] mianzhi,int m){
        int coinNum=0;
        int i = mianzhi.length-1;
        while (m!=0 && i!=-1){
            coinNum += m/mianzhi[i];
            m = m%mianzhi[i--];
        }
        if (m==0){
            return coinNum;
        }else {
            return -1;
        }
    }
}
