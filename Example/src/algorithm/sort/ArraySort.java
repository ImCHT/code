package algorithm.sort;

import java.util.Arrays;

public abstract class ArraySort {
    public abstract int[] sort(int[] sourceArray);
    //交换数组中两个数
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //得到数组最大数
    public int getMaxValue(int[] arr){
        int maxValue = arr[0];
        for (int value:arr) {
            if (maxValue<value){
                maxValue = value;
            }
        }
        return maxValue;
    }
    //向数组加数
    public int[] arrAppend(int[] arr,int value){
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1] = value;
        return arr;
    }
    //得到数的位数
    public int getNumLength(long num){
        if(num==0){
            return 1;
        }
        int length = 0;
        for (long temp = num; temp != 0 ; temp/=10) {
            length++;
        }
        return length;
    }
}
