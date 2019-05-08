package algorithm.sort;

import java.util.Arrays;
//基数排序
//将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
//从最低位开始，依次进行一次排序
//从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
//时间复杂度O(n*k)
//稳定
public class RadixSort extends ArraySort {
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new RadixSort().sort(sourceArray);
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
        int maxDigit = getMaxDight(arr);
        return radixSort(arr,maxDigit);
    }
    //获取最高位
    private int getMaxDight(int[] arr){
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
    }
    //基数排序
    private int[] radixSort(int[] arr,int maxDight){
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDight; i++,dev*=10,mod*=10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod*2][0];
            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j]%mod)/dev)+mod;
                counter[bucket] = arrAppend(counter[bucket],arr[j]);
            }
            int pos = 0;
            for (int[] bucket:counter) {
                for (int value:bucket) {
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }
}
