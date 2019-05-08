package leetcode.dynamicprogram;

/*
    题目描述：
    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
    影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
    思路：
    其实实际上就是就间隔数和和最小
    1. 递归
    2. 动态规划：opt数组
 */
public class LeetCode198 {
    public static void main(String[] args){

    }
    //动态规划。不考虑环。有opt数组
    public static int rob(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] optNums = new int[nums.length];
        optNums[0] = nums[0];
        optNums[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < optNums.length; i++) {
            int case1 = nums[i]+optNums[i-2];
            int case2 = optNums[i-1];
            optNums[i] = Math.max(case1,case2);
        }
        return optNums[nums.length-1];
    }
    //动态规划,不用O(n)的空间。没有opt[]数组
    public int rob1(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int opt0 = nums[0];
        int opt1 = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int case1 = nums[i]+opt0;
            int case2 = opt1;
            opt0 = opt1;
            opt1 = Math.max(case1,case2);
        }
        return opt1;
    }
}
