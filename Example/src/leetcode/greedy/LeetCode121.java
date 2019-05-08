package leetcode.greedy;

/*
    ��Ŀ������
    ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
    ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
    ע���㲻���������Ʊǰ������Ʊ��
    ˼·��
    1. ����ѭ�����Ӻ���ǰ�������õ�ÿ���Ӧ���������O(n2)
    2. ����ѭ������ǰ�����������һ�εõ�����֮ǰ����ͼ۸񣬵ڶ��εõ�������ʱ���������O(2n)��
    3. ͬ2�ķ�������ͬ��һ��ѭ���ڸ㶨
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
        //ÿ�����򵽵���ͼ۸�
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }
            minPrice[i] = min;
        }
        //ÿ����׬�ĵ��������
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i]-minPrice[i];
            if(profit>max){
                max = profit;
            }
        }
        return max;
    }
}
