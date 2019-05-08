package algorithm.sort;

import java.util.Arrays;
//ð������
//�Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
//��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ��ⲽ���������Ԫ�ػ�����������
//������е�Ԫ���ظ����ϵĲ��裬�������һ����
//����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
//ʱ�临�Ӷ�O(n2)
//�ȶ�
//��Ϥ
public class BubbleSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new BubbleSort().sort(sourceArray);
        for (int i:sourceArray) {
            System.out.print(i);
        }
        System.out.println();
        for (int i:arrayAfterSort) {
            System.out.print(i);
        }
    }
    @Override
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        for (int i = 0; i <arr.length ; i++) {
            boolean flag = true;//��־λ�����һ��ѭ���Ĺ����ж�û�н�������ô�����Ѿ�����
            for (int j = arr.length-1; j >i ; j--) {
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag = false;
                }
                if (flag)
                    break;
            }
        }
        return  arr;
    }
}
