package leetcode.doublepointer;
/*
    ��Ŀ������
    ����һ���Ѱ����������� ���������飬�ҵ�������ʹ���������֮�͵���Ŀ������
    ����Ӧ�÷����������±�ֵ index1 �� index2������ index1 ����С�� index2��
    ˵��:
    ���ص��±�ֵ��index1 �� index2�����Ǵ��㿪ʼ�ġ�
    ����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
    ˼·��
    1. ˫ָ��,һ��ָ������ߣ�һ��ָ�����ұߣ�ʱ�临�Ӷ�O(n)��
       �ʹ���Ŀ��ֵ�Ļ������ұ�ָ���1����С��Ŀ��ֵ�Ļ��������ָ���1���������ָ��������˵��û�ҵ�
    2. 2��forѭ����ʱ�临�Ӷ�O(n2)
*/
public class LeetCode167 {
    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int[] index;
        index = twoSum(numbers,26);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        //�������
        if(numbers==null){
            return null;
        }
        int left = 1;
        int right = numbers.length;
        while ((left!=right) && (numbers[left-1]+numbers[right-1]!=target)){
            if(numbers[left-1]+numbers[right-1]>target){
                right--;
            }else if(numbers[left-1]+numbers[right-1]<target){
                left++;
            }
        }
        //�ҵ���
        if(left!=right){
            int[] result = new int[2];
            result[0] = left;
            result[1] = right;
            return result;
        }else {
            return null;
        }
    }
}
