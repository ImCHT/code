package algorithm.sort;

import util.Utility;

import java.util.Arrays;

/**
 *   堆排序
     a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
     b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
     c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
     时间复杂度O(nlogn)
     不稳定
     不太懂,怎么构建堆
 */
public class HeapSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new HeapSort().sort(sourceArray);
        for (int i:sourceArray) {
            System.out.print(i);
        }
    }
    //堆排序，升序
    @Override
    public int[] sort(int[] sourceArray) {
        heapSort(sourceArray);
        return sourceArray;
    }
    /**
     * 堆排序
     * 升序，需要构建最大堆
     */
    public static void heapSort(int[] array){
        int length = array.length-1;
        //构建最大堆
        for (int i = array.length/2; i >= 0; i--) {
            heapify(array,i,length);
        }
        while (length>0){
            Utility.swap(array,0,length--);
            heapify(array,0,length);
        }
    }

    /**
     * 将位置为i的数据放在堆中的合适位置
     * @param array
     * @param i
     * @param length    数组中堆结构的数据量
     */
    private static void heapify(int[] array,int i,int length){
        int left = 2*i+1;
        int right = 2*i+2;
        int max = i;
        if (left<=length && array[left]>array[max]){
            max = left;
        }
        if (right<=length && array[right]>array[max]){
            max = right;
        }
        if (max!=i){
            Utility.swap(array,i,max);
            heapify(array,max,length);
        }
    }
}
