package leetcode.array;

/**
 * ��Ŀ������
 * ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
 ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�
 ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
 ����˼·��
 1. ȫ��9���ٶ���һ������
 2. ��ȫ��9��
 */
public class LeetCode66 {
    public static void main(String[] args){

    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            if (digits[i]!=9){
                digits[i] += 1;
                break;
            }else {
                digits[i] = 0;
                if (i==0){
                    int[] result = new int[digits.length+1];
                    result[0] = 1;
                    for (int j = 1; j < result.length; j++) {
                        result[j] = 0;
                        return result;
                    }
                }
            }
        }
        return digits;
    }
}
