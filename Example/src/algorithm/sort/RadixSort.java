package algorithm.sort;

import java.util.Arrays;
//��������
//�����д��Ƚ���ֵ����������ͳһΪͬ������λ���ȣ���λ�϶̵���ǰ�油��
//�����λ��ʼ�����ν���һ������
//�����λ����һֱ�����λ��������Ժ�, ���оͱ��һ����������
//ʱ�临�Ӷ�O(n*k)
//�ȶ�
public class RadixSort extends ArraySort {
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new RadixSort().sort(sourceArray);
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
        int maxDigit = getMaxDight(arr);
        return radixSort(arr,maxDigit);
    }
    //��ȡ���λ
    private int getMaxDight(int[] arr){
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
    }
    //��������
    private int[] radixSort(int[] arr,int maxDight){
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDight; i++,dev*=10,mod*=10) {
            // ���Ǹ����������������չһ�������������� [0-9]��Ӧ������[10-19]��Ӧ���� (bucket + 10)
            int[][] counter = new int[mod*2][0];
            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j]%mod)/dev)+mod;
                counter[bucket] = arrAppend(counter[bucket],arr[j]);
            }
            int pos = 0;
            for (int[] bucket:counter) {
                for (int value:bucket) {
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }
}
