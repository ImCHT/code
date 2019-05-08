package leetcode.dynamicprogram;

/*
    ��Ŀ������
    ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�
    Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
    ����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
    ˼·��
    ��ʵʵ���Ͼ��Ǿͼ�����ͺ���С
    1. �ݹ�
    2. ��̬�滮��opt����
 */
public class LeetCode198 {
    public static void main(String[] args){

    }
    //��̬�滮�������ǻ�����opt����
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
    //��̬�滮,����O(n)�Ŀռ䡣û��opt[]����
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
