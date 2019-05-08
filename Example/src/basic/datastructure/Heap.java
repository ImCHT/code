package basic.datastructure;

import util.Utility;

import java.util.PriorityQueue;

public class Heap {
    /**
     * 根据数组创建最小堆
     * 1. 模拟堆一个一个插入的过程。时间复杂度)O(nlogn)
     * 2. 从中间一直往前构建堆，时间复杂度O(n)
     * @param array
     * @return
     */
    public static int[] createHeap(int[] array){
        //1. 模拟堆一个一个插入的过程。时间复杂度O(nlogn)
//        for (int i = 1; i < array.length; i++) {
//            int temp = i+1;
//            while (temp!=1){
//                //比上层小的话，往上浮
//                if (array[temp-1]<array[temp/2-1]){
//                    Utility.swap(array,temp-1,temp/2-1);
//                    temp = temp/2;
//                }else {
//                    break;
//                }
//            }
//        }
        //2. 从中间一直往前构建堆，时间复杂度O(n)
        int length = array.length-1;
        //构建最大堆
        for (int i = array.length/2; i >= 0; i--) {
            heapify(array,i,length);
        }
        return array;
    }

    /**
     * 拿掉一个最小堆堆顶数据
     * @param array
     * @return
     */
    public static int[] poll(int[] array){
        Utility.swap(array,0,array.length-1);
        int temp = 0;
        while (temp*2+1<array.length-1){
            if (array[temp]>array[temp*2+1]){
                Utility.swap(array,temp,temp*2+1);
                temp = temp*2+1;
            }else if (array[temp]>array[temp*2+2]){
                Utility.swap(array,temp,temp*2+2);
                temp = temp*2+2;
            }else {
                break;
            }
        }
        return array;
    }
    /**
     * 将位置为i的数据放在堆中的合适位置
     * @param array
     * @param i
     * @param length    数组中堆结构的数据量
     */
    public static void heapify(int[] array,int i,int length){
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
