package leetcode.dynamicprogram;

import java.util.Arrays;

/*
    ��Ŀ������
    ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ�Χ��һȦ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�
    ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
    ����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
    ˼·��
    1. ��̬�滮��ֱ�ӱȽ����Σ��ֱ�������һ�������һ��
    2. ���ж���û�п��ܵ�һ�������һ����ȡ�����п��ܷ������αȽϡ�����һ�αȽ�
    ע��㣺
    �õ�ȥ�����һ���ַ����ַ�����Ҫ�ã�string.subString(0,string.length-1);
 */
public class LeetCode213 {
    public static void main(String[] args){

    }
    //���ǻ�
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
    //�жϣ��Ƿ���ڵ�һ������ݶ���ѡ��������������ֱ�ӷ���һ�μ������������ö��μ���
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
        //������ѡ����ʵ��һ����һ�����������Σ��Ƚ�
        if(nums[len-1]+optNums[len-3]>optNums[len-2] && nums[2]+nums[0]>nums[1]){
            int case1 = LeetCode198.rob(Arrays.copyOfRange(nums,0,nums.length-1));
            int case2 = LeetCode198.rob(Arrays.copyOfRange(nums,1,nums.length));
            return Math.max(case1,case2);
        }else {
            return optNums[len-1];
        }
    }
    //��̬�滮�������ǻ�������opt[]����
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
