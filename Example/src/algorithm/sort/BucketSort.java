package algorithm.sort;

import java.util.Arrays;
//Ͱ����,��ÿ��Ͱ���ɵ���ֵ��ΧΪ1ʱ�����Ǽ�������
//���ù̶������Ŀ�Ͱ��
//�����ݷŵ���Ӧ��Ͱ�С�
//��ÿ����Ϊ�յ�Ͱ�����ݽ�������
//ƴ�Ӳ�Ϊ�յ�Ͱ�����ݣ��õ����
//ʱ�临�Ӷ�O(n+k)
//�ȶ�
public class BucketSort extends ArraySort {
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new BucketSort().sort(sourceArray);
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

        return bucketSort(arr,5);
    }
    private int[] bucketSort(int[] arr,int bucketSize){
        if(arr.length==0){
            return arr;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value:arr) {
            if (value<minValue){
                minValue = value;
            }else if(value>maxValue){
                maxValue = value;
            }
        }
        int bucketCount = (int)Math.floor(maxValue-minValue)/bucketSize+1;
        int[][] buckets = new int[bucketCount][0];
        //����ӳ�亯�������ݷ��䵽����Ͱ��
        for (int i = 0; i < arr.length; i++) {
            int index = (int)Math.floor((arr[i]-minValue)/bucketSize);
            buckets[index] = arrAppend(buckets[index],arr[i]);
        }
        int arrIndex = 0;
        for (int[] bucket:buckets) {
            if(bucket.length<=0){
                continue;
            }
            //��ÿ��Ͱ������������ʹ�ò�������
            bucket = new InsertSort().sort(bucket);
            for (int value:bucket) {
                arr[arrIndex++] = value;
            }
        }
        return  arr;
    }
}
