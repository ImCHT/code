package algorithm.sort;

/**
 * �鲢����
 ����ռ䣬ʹ���СΪ�����Ѿ���������֮�ͣ��ÿռ�������źϲ�������У�
 �趨����ָ�룬���λ�÷ֱ�Ϊ�����Ѿ��������е���ʼλ�ã�
 �Ƚ�����ָ����ָ���Ԫ�أ�ѡ�����С��Ԫ�ط��뵽�ϲ��ռ䣬���ƶ�ָ�뵽��һλ�ã�
 �ظ����� 3 ֱ��ĳһָ��ﵽ����β��
 ����һ����ʣ�µ�����Ԫ��ֱ�Ӹ��Ƶ��ϲ�����β��
 ʱ�临�Ӷ�O(nlogn)
 �ȶ�
 �ݹ飬�����зֳɵȳ��ȵ�����
 */
public class MergeSort extends ArraySort{
    public static void main(String[] args){
        int[] sourceArray = {3,2,1,4,5,2,6};
        int[] arrayAfterSort = new MergeSort().sort(sourceArray);
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
        mergeSort(sourceArray,0,sourceArray.length-1);
        return sourceArray;
    }

    /**
     * �鲢����
     * �����ͺ͸�����
     * @param array
     * @param low
     * @param high
     */
    public static void mergeSort(int[] array,int low,int high){
        if (low<high){
            int mid = low+(high-low)/2;
            mergeSort(array,low,mid);
            //����1����ѭ��
            mergeSort(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }
    private static void merge(int[] array,int low,int mid,int high){
        int[] tempArray = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int tempIndex = 0;
        while (left<=mid && right<=high){
            if (array[left]<array[right]){
                tempArray[tempIndex++] = array[left++];
            }else {
                tempArray[tempIndex++] = array[right++];
            }
        }
        for (int i = left; i <= mid; i++) {
            tempArray[tempIndex++] = array[left++];
        }
        for (int i = right; i <= high; i++) {
            tempArray[tempIndex++] = array[right++];
        }
        for (int i = 0; i < tempArray.length; i++) {
            array[low+i] = tempArray[i];
        }
    }
}
