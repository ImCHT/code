package leetcode.greedy;

/*
    题目描述：
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    思路：
    连续两天之内，有利润就买，否则不买，从头到尾遍历数组
 */
public class LeetCode122 {
    public static void main(String[] args){

    }
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            profit += (prices[i+1]-prices[i]>0?prices[i+1]-prices[i]:0);
        }
        return profit;
    }
}
