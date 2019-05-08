package leetcode.greedy;

/*
    题目描述：
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    注意你不能在买入股票前卖出股票。
    思路：
    1. 二次循环，从后往前遍历，得到每天对应的最大利润。O(n2)
    2. 二次循环，从前往后遍历，第一次得到那天之前的最低价格，第二次得到那天卖时的最大利润。O(2n)。
    3. 同2的方法，不同在一次循环内搞定
 */
public class LeetCode121 {
    public static void main(String[] args){

    }
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }
    public int maxProfit1(int[] prices) {
        int max = 0;
        int[] minPrice = new int[prices.length];
        int min = Integer.MAX_VALUE;
        //每天能买到的最低价格
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }
            minPrice[i] = min;
        }
        //每天能赚的的最大利润
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i]-minPrice[i];
            if(profit>max){
                max = profit;
            }
        }
        return max;
    }
}
