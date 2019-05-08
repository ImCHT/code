package algorithm.sort;

import java.util.Arrays;
//桶排序,当每个桶容纳的数值范围为1时，就是技术排序
//设置固定数量的空桶。
//把数据放到对应的桶中。
//对每个不为空的桶中数据进行排序。
//拼接不为空的桶中数据，得到结果
//时间复杂度O(n+k)
//稳定
public class BucketSort extends ArraySort {
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new BucketSort().sort(sourceArray);
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

        return bucketSort(arr,5);
    }
    private int[] bucketSort(int[] arr,int bucketSize){
        if(arr.length==0){
            return arr;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value:arr) {
            if (value<minValue){
                minValue = value;
            }else if(value>maxValue){
                maxValue = value;
            }
        }
        int bucketCount = (int)Math.floor(maxValue-minValue)/bucketSize+1;
        int[][] buckets = new int[bucketCount][0];
        //利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int)Math.floor((arr[i]-minValue)/bucketSize);
            buckets[index] = arrAppend(buckets[index],arr[i]);
        }
        int arrIndex = 0;
        for (int[] bucket:buckets) {
            if(bucket.length<=0){
                continue;
            }
            //对每个桶进行排序，这里使用插入排序
            bucket = new InsertSort().sort(bucket);
            for (int value:bucket) {
                arr[arrIndex++] = value;
            }
        }
        return  arr;
    }
}
