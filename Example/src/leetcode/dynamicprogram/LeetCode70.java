package leetcode.dynamicprogram;

/*
    题目描述：
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    注意：给定 n 是一个正整数。
    思路：
    1. 动态规划：opt数组
    2. 递归

 */
public class LeetCode70 {
    public static void main(String[] args){
        System.out.println(climbStairs(6));
    }
    //思路1
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
    //思路2
    public static  int climbStairs1(int n) {
        if (n<=2){
            return n;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }
}
