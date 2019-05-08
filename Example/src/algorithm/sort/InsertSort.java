package algorithm.sort;

import java.util.Arrays;
//插入排序
//将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
//从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
//时间复杂度O(n2)
//稳定
public class InsertSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new InsertSort().sort(sourceArray);
        for (int i:sourceArray) {
            System.out.print(i);
        }
        System.out.println();
        for (int i:arrayAfterSort) {
            System.out.print(i);
        }
    }
    //小循环采用移动插入的形式,小循环采用while
    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        return arr;
    }

    //小循环采用移动插入的形式,小循环采用for
    public int[] sort1(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if(arr[j-1]>temp){
                    arr[j] = arr[j-1];
                }else{
                    break;
                }
            }
            if(j!=i){
                arr[j] = temp;
            }
        }
        return arr;
    }

    //小循环采用交换的形式
    public int[] sort2(int[] sourceArray) {
        //对参数进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        //需要进行arr.length-1轮
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                //如果逆序的话，交换
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                //如果不逆序，说明以及在合理位置，跳出循环
                else{
                    break;
                }
            }
        }
        return arr;
    }
}
