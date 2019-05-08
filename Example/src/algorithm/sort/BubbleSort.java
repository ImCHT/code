package algorithm.sort;

import java.util.Arrays;
//冒泡排序
//比较相邻的元素。如果第一个比第二个大，就交换他们两个。
//对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
//针对所有的元素重复以上的步骤，除了最后一个。
//持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
//时间复杂度O(n2)
//稳定
//熟悉
public class BubbleSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new BubbleSort().sort(sourceArray);
        for (int i:sourceArray) {
            System.out.print(i);
        }
        System.out.println();
        for (int i:arrayAfterSort) {
            System.out.print(i);
        }
    }
    @Override
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        for (int i = 0; i <arr.length ; i++) {
            boolean flag = true;//标志位：如果一次循环的过程中都没有交换，那么数组已经有序
            for (int j = arr.length-1; j >i ; j--) {
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = false;
                }
                if (flag)
                    break;
            }
        }
        return  arr;
    }
}
