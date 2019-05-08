package leetcode.doublepointer;
/*
    题目描述：
    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
    说明:
    返回的下标值（index1 和 index2）不是从零开始的。
    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
    思路：
    1. 双指针,一个指向最左边，一个指向最右边，时间复杂度O(n)。
       和大于目标值的话，最右边指针减1；和小于目标值的话，最左边指针加1。如果左右指针相遇，说明没找到
    2. 2次for循环，时间复杂度O(n2)
*/
public class LeetCode167 {
    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int[] index;
        index = twoSum(numbers,26);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        //特殊情况
        if(numbers==null){
            return null;
        }
        int left = 1;
        int right = numbers.length;
        while ((left!=right) && (numbers[left-1]+numbers[right-1]!=target)){
            if(numbers[left-1]+numbers[right-1]>target){
                right--;
            }else if(numbers[left-1]+numbers[right-1]<target){
                left++;
            }
        }
        //找到了
        if(left!=right){
            int[] result = new int[2];
            result[0] = left;
            result[1] = right;
            return result;
        }else {
            return null;
        }
    }
}
