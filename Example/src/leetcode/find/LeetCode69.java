package leetcode.find;

/*
    ��Ŀ������
    ʵ�� int sqrt(int x) ������
    ���㲢���� x ��ƽ���������� x �ǷǸ�������
    ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
    ˼·��
    ���ֲ��ң�n*n<x,(n+1)(n+1)>x������n
 */
public class LeetCode69 {
    public static void main(String[] args){
        System.out.println(mySqrt(0));
    }
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (true){
            long mid = left+(right-left)/2;
            if(mid*mid<=x && (mid+1)*(mid+1)>x){
                return (int) mid;
            }else if(mid*mid>x){
                right = (int) mid-1;
            }else if((mid+1)*(mid+1)<=x){
                left = (int) mid+1;
            }
        }
    }
}
