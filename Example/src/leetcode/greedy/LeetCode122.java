package leetcode.greedy;

/*
    ��Ŀ������
    ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
    ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
    ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
    ˼·��
    ��������֮�ڣ���������򣬷����򣬴�ͷ��β��������
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
