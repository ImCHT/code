package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import util.Utility;

/*
    题目描述
    在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 */
public class LeetCode215 {
    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest2(nums,2));
    }
    //调用jdk的排序方法。时间复杂度O(nlogn),空间复杂度O(n)。
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    //构建最大堆。时间复杂度O(nlogn),空间复杂度O(n)。也可以构建小顶堆，维护堆的大小为k。
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
    //利用快速排序的切分函数，实现快速选择。时间复杂度O(n),空间复杂度O(1)
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
    //切分函数，两边都包括，返回开头数排序后的位置
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
