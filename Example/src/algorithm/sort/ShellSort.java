package algorithm.sort;

import java.util.Arrays;

//希尔排序，又称缩小增量排序。根据增量，将元素分为不同组，每组进行插入排序
//选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
//按增量序列个数 k，对序列进行 k 趟排序；
//每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
//时间复杂度O(nlogn),线性对数
//不稳定
//还不熟练
public class ShellSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new ShellSort().sort(sourceArray);
        for (int i:sourceArray) {
            System.out.print(i);
        }
        System.out.println();
        for (int i:arrayAfterSort) {
            System.out.print(i);
        }
    }
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        int gap = 1;
        while(gap<arr.length){
            gap = gap*3+1;
        }
        while (gap>0){
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i-gap;
                while (j>=0 && arr[j]>temp){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = temp;
            }
            gap = (int)Math.floor(gap/3);//向下取整
        }
        return arr;
    }
}
