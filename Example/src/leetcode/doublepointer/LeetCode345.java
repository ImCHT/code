package leetcode.doublepointer;

/*
    ע��㣺
    �ַ�ת��ΪСдCharacter.toLowerCase
    String��indexOf�����ж��ַ��ڲ����ַ�����
    ��Ŀ������
    ��дһ�����������ַ�����Ϊ���룬��ת���ַ����е�Ԫ����ĸ��
    ˼·��
    1. ��һ��ɨ�裬��Ԫ����ĸ�浽������,�ڶ���ɨ���滻Ԫ����ĸ��ʱ�临�Ӷ�O(2n)
    2. ˫ָ�룬һ����ǰ����һ���Ӻ���ǰ��ǰ��ָ�붼ָ��Ԫ����ĸ������ָ�벻���ʱ��������ʱ�临�Ӷ�O(n)
 */

import util.*;

public class LeetCode345 {
    public static void main(String[] args){
        System.out.println(reverseVowels1("lcd"));
    }
    //˼·1
    public static String reverseVowels(String s) {
        if (s==null){
            return null;
        }
        StringBuilder oldStr = new StringBuilder(s);
        String vowel = "aeiou";
        char[] vowelChar = new char[oldStr.length()];
        int indexOfVowel = 0;
        //��һ��ɨ�裬��Ԫ����ĸ�浽������
        for (int i = 0; i < oldStr.length(); i++) {
            //��Ԫ����ĸ
            if(vowel.indexOf(Character.toLowerCase(oldStr.charAt(i)))!=-1){
                vowelChar[indexOfVowel++] = oldStr.charAt(i);
            }
        }
        //�ڶ���ɨ���滻Ԫ����ĸ
        for (int i = 0; i < oldStr.length(); i++) {
            //��Ԫ����ĸ
            if(vowel.indexOf(Character.toLowerCase(oldStr.charAt(i)))!=-1){
                oldStr.setCharAt(i,vowelChar[--indexOfVowel]);
            }
        }
        return oldStr.toString();
    }
    //˼·2
    public static String reverseVowels1(String s) {
        StringBuilder newString = new StringBuilder(s);
        int left = 0;
        int right = s.length()-1;
        String vowel = "aeiou";
        while (true){
            //����ߵ�Ԫ����ĸ
            while (left<newString.length() && vowel.indexOf(Character.toLowerCase(newString.charAt(left)))==-1){
                left++;
            }
            //���ұߵ�Ԫ����ĸ
            while (right>0 && vowel.indexOf(Character.toLowerCase(newString.charAt(right)))==-1){
                right--;
            }
            if(left<right){
                //����
                Utility.swapChar(newString,left,right);
                left++;
                right--;
            }else {
                break;
            }
        }
        return newString.toString();
    }
}
