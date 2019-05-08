package algorithm.sort;

import java.util.Arrays;
//��������
//����һ���������е�һ��Ԫ�ؿ���һ���������У��ѵڶ���Ԫ�ص����һ��Ԫ�ص�����δ�������С�
//��ͷ��β����ɨ��δ�������У���ɨ�赽��ÿ��Ԫ�ز����������е��ʵ�λ�á�������������Ԫ�������������е�ĳ��Ԫ����ȣ��򽫴�����Ԫ�ز��뵽���Ԫ�صĺ��档��
//ʱ�临�Ӷ�O(n2)
//�ȶ�
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
    //Сѭ�������ƶ��������ʽ,Сѭ������while
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

    //Сѭ�������ƶ��������ʽ,Сѭ������for
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

    //Сѭ�����ý�������ʽ
    public int[] sort2(int[] sourceArray) {
        //�Բ������п��������ı��������
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        //��Ҫ����arr.length-1��
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                //�������Ļ�������
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                //���������˵���Լ��ں���λ�ã�����ѭ��
                else{
                    break;
                }
            }
        }
        return arr;
    }
}
