package algorithm.sort;

import java.util.Arrays;

//��������
//��O(n)��ʱ��ɨ��һ���������� A����ȡ��Сֵ min �����ֵ max
//����һ���µĿռ䴴���µ����� B������Ϊ ( max - min + 1)
//���� B �� index ��Ԫ�ؼ�¼��ֵ�� A ��ĳԪ�س��ֵĴ���
//������Ŀ���������У�������߼��Ǳ������� B�������ӦԪ���Լ���Ӧ�ĸ���
//ʱ�临�Ӷ�O(n+k)
//�ȶ���
public class CountingSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new CountingSort().sort(sourceArray);
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
        //��arr���п���
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        int maxValue = getMaxValue(arr);
        return countingSort(arr,maxValue);
    }
    private int[] countingSort(int[] arr,int maxValue){
        int bucketLen = maxValue+1;
        int[] bucket = new int[bucketLen];
        //ɨ�����飬����Ͱ��
        for (int value: arr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        //��Ͱ�������������
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i]>0){
                arr[sortedIndex++]=i;
                bucket[i]--;
            }
        }
        return arr;
    }
}
