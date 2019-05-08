package leetcode.dynamicprogram;

import java.util.Arrays;

/*
    题目描述：
    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
    同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
    思路：
    1. 动态规划。直接比较两次，分别舍弃第一个和最后一个
    2. 先判断有没有可能第一个和最后一个都取，若有可能返回两次比较。否则，一次比较
    注意点：
    得到去除最后一个字符的字符串需要用：string.subString(0,string.length-1);
 */
public class LeetCode213 {
    public static void main(String[] args){

    }
    //考虑环
    public static int rob(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int case1 = LeetCode198.rob(Arrays.copyOfRange(nums,0,nums.length-1));
        int case2 = LeetCode198.rob(Arrays.copyOfRange(nums,1,nums.length));
        return Math.max(case1,case2);
    }
    //判断，是否存在第一和最后房屋都被选的情况，如果不是直接返回一次计算结果，而不用二次计算
    public static int rob1(int[] nums){
        if (nums==null || nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] optNums = rob2(nums);
        int len = nums.length;
        //两个都选。其实第一个不一定。计算两次，比较
        if(nums[len-1]+optNums[len-3]>optNums[len-2] && nums[2]+nums[0]>nums[1]){
            int case1 = LeetCode198.rob(Arrays.copyOfRange(nums,0,nums.length-1));
            int case2 = LeetCode198.rob(Arrays.copyOfRange(nums,1,nums.length));
            return Math.max(case1,case2);
        }else {
            return optNums[len-1];
        }
    }
    //动态规划。不考虑环。返回opt[]数组
    public static int[] rob2(int[] nums) {
//        if (nums==null || nums.length==0){
//            return 0;
//        }
//        if (nums.length==1){
//            return nums[0];
//        }else if(nums.length==2){
//            return Math.max(nums[0],nums[1]);
//        }
        int[] optNums = new int[nums.length];
        optNums[0] = nums[0];
        optNums[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < optNums.length; i++) {
            int case1 = nums[i]+optNums[i-2];
            int case2 = optNums[i-1];
            optNums[i] = Math.max(case1,case2);
        }
        return optNums;
    }
}
