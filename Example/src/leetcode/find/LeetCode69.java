package leetcode.find;

/*
    题目描述：
    实现 int sqrt(int x) 函数。
    计算并返回 x 的平方根，其中 x 是非负整数。
    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    思路：
    二分查找，n*n<x,(n+1)(n+1)>x，返回n
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
