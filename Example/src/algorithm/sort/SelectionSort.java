package algorithm.sort;

import java.util.Arrays;
//选择排序
//首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
//再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
//重复第二步，直到所有元素均排序完毕。
//时间复杂度O(n2)
//稳定
//熟悉
public class SelectionSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new SelectionSort().sort(sourceArray);
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
        //需要经过n-1轮比较
        for (int i = 0; i <arr.length-1 ; i++) {
            int min = i;
            //每轮需要比较的次数为N-i-1
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min]>arr[j]){
                    //记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }
}
