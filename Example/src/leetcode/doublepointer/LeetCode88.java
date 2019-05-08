package leetcode.doublepointer;

/*
    ��Ŀ������
    �������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣
        ˵��:
        ��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
        ����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
    ˼·��
    1. ������������ָ��ָ������������࣬�ڶ�������С�ڵ�һ������ģ��������������Ȼ����ȥ��ʱ�临�Ӷ�O(n2)
    2. �鲢�����Ƚ���һ������������Ƶ�һ���������У�Ȼ��Ƚ��������������ݣ�С�ķŵ���һ�������С�ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
 */
public class LeetCode88 {
    public static void main(String[] args){
        int[] nums1 = {2,0};

    }
    //˼·2
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums1 = new int[m];
        for (int i = 0; i < m; i++) {
            newNums1[i] = nums1[i];
        }
        int nums1Index = 0;
        int nums2Index = 0;
        for (int i = 0; i < n+m; i++) {
            //����1�Ѹ�����
            if(nums1Index>=m){
                nums1[i] = nums2[nums2Index++];
                continue;
            }else if(nums2Index>=n){    //����2�Ѹ�����
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
