package leetcode.dynamicprogram;

/*
    ��Ŀ������
    ������������¥�ݡ���Ҫ n ������ܵ���¥����
    ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
    ע�⣺���� n ��һ����������
    ˼·��
    1. ��̬�滮��opt����
    2. �ݹ�

 */
public class LeetCode70 {
    public static void main(String[] args){
        System.out.println(climbStairs(6));
    }
    //˼·1
    public static  int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int[] optNums = new int[n];
        optNums[0] = 1;
        optNums[1] = 2;
        for (int i = 2; i < n; i++) {
            optNums[i] = optNums[i-1]+optNums[i-2];
        }
        return optNums[n-1];
    }
    //˼·2
    public static  int climbStairs1(int n) {
        if (n<=2){
            return n;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }
}
