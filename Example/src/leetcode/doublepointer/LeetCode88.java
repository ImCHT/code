package leetcode.doublepointer;

/*
    题目描述：
    给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
        说明:
        初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    思路：
    1. 插入排序，两个指针指向两个数组左侧，第二个数组小于第一个数组的，后面的数往后移然后插进去，时间复杂度O(n2)
    2. 归并排序，先将第一个数组的数复制到一个新数组中，然后比较两个数组中内容，小的放到第一个数组中。时间复杂度O(n),空间复杂度O(n)
 */
public class LeetCode88 {
    public static void main(String[] args){
        int[] nums1 = {2,0};

    }
    //思路2
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums1 = new int[m];
        for (int i = 0; i < m; i++) {
            newNums1[i] = nums1[i];
        }
        int nums1Index = 0;
        int nums2Index = 0;
        for (int i = 0; i < n+m; i++) {
            //数组1已复制完
            if(nums1Index>=m){
                nums1[i] = nums2[nums2Index++];
                continue;
            }else if(nums2Index>=n){    //数组2已复制完
                nums1[i] = newNums1[nums1Index++];
                continue;
            }
            if(newNums1[nums1Index]<nums2[nums2Index]){
                nums1[i] = newNums1[nums1Index++];
            }else {
                nums1[i] = nums2[nums2Index++];
            }
        }
    }
}
