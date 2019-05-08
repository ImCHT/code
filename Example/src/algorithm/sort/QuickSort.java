package algorithm.sort;

import java.util.Arrays;

//��������
//������������һ��Ԫ�أ���Ϊ ����׼����pivot��;
//�����������У�����Ԫ�رȻ�׼ֵС�İڷ��ڻ�׼ǰ�棬����Ԫ�رȻ�׼ֵ��İ��ڻ�׼�ĺ��棨��ͬ�������Ե���һ�ߣ�������������˳�֮�󣬸û�׼�ʹ������е��м�λ�á������Ϊ������partition��������
//�ݹ�أ�recursive����С�ڻ�׼ֵԪ�ص������кʹ��ڻ�׼ֵԪ�ص�����������
//�з֣�����һ����׼���Ȼ�׼С�ķ��ڻ�׼��ߣ��Ȼ�׼��ķ��ڻ�׼���档
//�ݹ�,�з�
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
        //���û�׼ֵ(pivot)
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
