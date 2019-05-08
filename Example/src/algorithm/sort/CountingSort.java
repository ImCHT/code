package algorithm.sort;

import java.util.Arrays;

//计数排序
//花O(n)的时间扫描一下整个序列 A，获取最小值 min 和最大值 max
//开辟一块新的空间创建新的数组 B，长度为 ( max - min + 1)
//数组 B 中 index 的元素记录的值是 A 中某元素出现的次数
//最后输出目标整数序列，具体的逻辑是遍历数组 B，输出相应元素以及对应的个数
//时间复杂度O(n+k)
//稳定？
public class CountingSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new CountingSort().sort(sourceArray);
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
        //对arr进行拷贝
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        int maxValue = getMaxValue(arr);
        return countingSort(arr,maxValue);
    }
    private int[] countingSort(int[] arr,int maxValue){
        int bucketLen = maxValue+1;
        int[] bucket = new int[bucketLen];
        //扫描数组，放入桶中
        for (int value: arr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        //从桶里面把数倒出来
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i]>0){
                arr[sortedIndex++]=i;
                bucket[i]--;
            }
        }
        return arr;
    }
}
