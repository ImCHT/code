package algorithm.sort;

/**
 * 归并排序
 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 重复步骤 3 直到某一指针达到序列尾；
 将另一序列剩下的所有元素直接复制到合并序列尾。
 时间复杂度O(nlogn)
 稳定
 递归，不断切分成等长度的数组
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
     * 归并排序
     * 包含低和高索引
     * @param array
     * @param low
     * @param high
     */
    public static void mergeSort(int[] array,int low,int high){
        if (low<high){
            int mid = low+(high-low)/2;
            mergeSort(array,low,mid);
            //不加1会死循环
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
