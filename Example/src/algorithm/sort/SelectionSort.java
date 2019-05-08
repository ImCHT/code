package algorithm.sort;

import java.util.Arrays;
//ѡ������
//������δ�����������ҵ���С����Ԫ�أ���ŵ��������е���ʼλ��
//�ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ�أ�Ȼ��ŵ����������е�ĩβ��
//�ظ��ڶ�����ֱ������Ԫ�ؾ�������ϡ�
//ʱ�临�Ӷ�O(n2)
//�ȶ�
//��Ϥ
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
        //��Ҫ����n-1�ֱȽ�
        for (int i = 0; i <arr.length-1 ; i++) {
            int min = i;
            //ÿ����Ҫ�ȽϵĴ���ΪN-i-1
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min]>arr[j]){
                    //��¼Ŀǰ���ҵ�����СֵԪ�ص��±�
                    min = j;
                }
            }
            //���ҵ�����Сֵ��iλ�����ڵ�ֵ���н���
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }
}
