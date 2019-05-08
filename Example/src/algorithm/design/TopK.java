package algorithm.design;

import util.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * TopK����
 * ���������ҳ����/��С��ǰk����
 */
public class TopK {
    public static void main(String[] args) throws IOException {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<Integer> queue =  new TopK().partitionTopK(nums,5);
        for (int num:queue) {
            System.out.println(num);
        }
    }
    /**
     * ʹ�öѵķ���
     * ����Ϊ����
     * ����������Ҫ��С��
     * ����С������Ҫ����
     */
    public Queue<Integer> heap(int[] nums, int k){
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2){
                    return -1;
                }else if (o1<o2){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        for (int num:nums) {
            if (queue.size()<k){
                queue.offer(num);
            }else if (queue.peek()>num){
                queue.poll();
                queue.offer(num);
            }
        }
        return queue;
    }
    /**
     * ʹ�öѵķ���
     * ����Ϊ�ļ�·��
     */
    public Queue<Integer> heapFile(String fileName,int k) throws IOException{
        Queue<Integer> queue = new PriorityQueue<>(k);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<Integer> list = new ArrayList<>();
        String textLine;
        while ((textLine=bufferedReader.readLine())!=null){
            String[] strings = textLine.split(" ");
            for (String string:strings){
                int num = Integer.parseInt(string);
                if (queue.size()<k){
                    queue.offer(num);
                }else if (queue.peek()<num){
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue;
    }
    /**
     * ʹ���зֵķ�����ʱ�临�Ӷ�ΪO(n)
     * ����ֻ��Ϊ����,�ڴ���Ҫ�ŵ���
     * ������k����
     */
    public List<Integer> partitionTopK(int[] array,int k){
        List<Integer> list = new ArrayList<>();
        int left=0,right=0;
        int partitionIndex = partition(array,0,array.length-1);
        while (partitionIndex!=array.length-k){
            if (partitionIndex>array.length-k){
                right = partitionIndex-1;
            }else {
                left = partitionIndex+1;
            }
            partitionIndex = partition(array,left,right);
        }
        for (int i = partitionIndex; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
    private int partition(int[] array,int left,int right){
        int pivot = array[left];
        int index = left+1;
        for (int i = left+1; i <= right; i++) {
            if (array[i]<=pivot){
                Utility.swap(array,index++,i);
            }
        }
        Utility.swap(array,left,index-1);
        return index-1;
    }
}
