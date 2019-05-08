package leetcode.array;

/**
 * 题目描述：
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 你可以假设除了整数 0 之外，这个整数不会以零开头。
 解题思路：
 1. 全是9，再定义一个数组
 2. 不全是9，
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
