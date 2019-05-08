package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import util.Utility;

/*
    ��Ŀ����
    ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�

 */
public class LeetCode215 {
    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest2(nums,2));
    }
    //����jdk�����򷽷���ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(n)��
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    //�������ѡ�ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(n)��Ҳ���Թ���С���ѣ�ά���ѵĴ�СΪk��
    public static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?-1:o1<o2?1:0;
            }
        });
        for (Integer i:nums) {
            priorityQueue.add(i);
        }
        for (int i = 1; i < k; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
    //���ÿ���������зֺ�����ʵ�ֿ���ѡ��ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
    public static int findKthLargest2(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        int len = nums.length;
        while (true){
            int index = partition(nums,left,right);
            if(index>len-k){
                right = index-1;
            }else if (index<len-k){
                left = index+1;
            }else {
                return nums[index];
            }
        }
    }
    //�зֺ��������߶����������ؿ�ͷ��������λ��
    static int partition(int[] nums,int left,int right){
        if (left>=right){
            return left;
        }
        int pivot = nums[left];
        int index = left+1;
        for (int i = left+1; i <= right; i++) {
            if (nums[i]<pivot){
                Utility.swap(nums,index++,i);
            }
        }
        Utility.swap(nums,index-1,left);
        return index-1;
    }
}
