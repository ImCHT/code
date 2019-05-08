package algorithm.sort;

import util.Utility;

import java.util.Arrays;

/**
 *   ������
     a.���������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����;
     b.���Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ��"��"������ĩ��;
     c.���µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�����ִ�е���+�������裬ֱ��������������
     ʱ�临�Ӷ�O(nlogn)
     ���ȶ�
     ��̫��,��ô������
 */
public class HeapSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new HeapSort().sort(sourceArray);
        for (int i:sourceArray) {
            System.out.print(i);
        }
    }
    //����������
    @Override
    public int[] sort(int[] sourceArray) {
        heapSort(sourceArray);
        return sourceArray;
    }
    /**
     * ������
     * ������Ҫ��������
     */
    public static void heapSort(int[] array){
        int length = array.length-1;
        //��������
        for (int i = array.length/2; i >= 0; i--) {
            heapify(array,i,length);
        }
        while (length>0){
            Utility.swap(array,0,length--);
            heapify(array,0,length);
        }
    }

    /**
     * ��λ��Ϊi�����ݷ��ڶ��еĺ���λ��
     * @param array
     * @param i
     * @param length    �����жѽṹ��������
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
