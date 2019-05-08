package basic.datastructure;

import util.Utility;

import java.util.PriorityQueue;

public class Heap {
    /**
     * �������鴴����С��
     * 1. ģ���һ��һ������Ĺ��̡�ʱ�临�Ӷ�)O(nlogn)
     * 2. ���м�һֱ��ǰ�����ѣ�ʱ�临�Ӷ�O(n)
     * @param array
     * @return
     */
    public static int[] createHeap(int[] array){
        //1. ģ���һ��һ������Ĺ��̡�ʱ�临�Ӷ�O(nlogn)
//        for (int i = 1; i < array.length; i++) {
//            int temp = i+1;
//            while (temp!=1){
//                //���ϲ�С�Ļ������ϸ�
//                if (array[temp-1]<array[temp/2-1]){
//                    Utility.swap(array,temp-1,temp/2-1);
//                    temp = temp/2;
//                }else {
//                    break;
//                }
//            }
//        }
        //2. ���м�һֱ��ǰ�����ѣ�ʱ�临�Ӷ�O(n)
        int length = array.length-1;
        //��������
        for (int i = array.length/2; i >= 0; i--) {
            heapify(array,i,length);
        }
        return array;
    }

    /**
     * �õ�һ����С�ѶѶ�����
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
     * ��λ��Ϊi�����ݷ��ڶ��еĺ���λ��
     * @param array
     * @param i
     * @param length    �����жѽṹ��������
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
