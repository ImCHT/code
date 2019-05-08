package algorithm.sort;

import java.util.Arrays;

//ϣ�������ֳ���С�������򡣸�����������Ԫ�ط�Ϊ��ͬ�飬ÿ����в�������
//ѡ��һ���������� t1��t2��������tk������ ti > tj, tk = 1��
//���������и��� k�������н��� k ������
//ÿ�����򣬸��ݶ�Ӧ������ ti�����������зָ�����ɳ���Ϊ m �������У��ֱ�Ը��ӱ����ֱ�Ӳ������򡣽���������Ϊ 1 ʱ������������Ϊһ�������������ȼ�Ϊ�������еĳ��ȡ�
//ʱ�临�Ӷ�O(nlogn),���Զ���
//���ȶ�
//��������
public class ShellSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new ShellSort().sort(sourceArray);
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

        int gap = 1;
        while(gap<arr.length){
            gap = gap*3+1;
        }
        while (gap>0){
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i-gap;
                while (j>=0 && arr[j]>temp){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = temp;
            }
            gap = (int)Math.floor(gap/3);//����ȡ��
        }
        return arr;
    }
}
