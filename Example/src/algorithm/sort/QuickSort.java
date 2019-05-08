package algorithm.sort;

import java.util.Arrays;

//快速排序
//从数列中挑出一个元素，称为 “基准”（pivot）;
//重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
//递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
//切分：挑出一个基准，比基准小的放在基准左边，比基准大的放在基准后面。
//递归,切分
public class QuickSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new QuickSort().sort(sourceArray);
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
        return quickSort(arr,0,arr.length-1);
    }
    private int[] quickSort(int[] arr,int left,int right){
        if(left<right){
            int partitionIndex = partition(arr,left,right);
            quickSort(arr,left,partitionIndex-1);
            quickSort(arr,partitionIndex+1,right);
        }
        return arr;
    }
    private int partition(int[] arr,int left,int right){
        //设置基准值(pivot)
        int pivot = left;
        int index = pivot+1;
        for (int i = index; i <= right; i++) {
            if(arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);
        return index-1;
    }

}
