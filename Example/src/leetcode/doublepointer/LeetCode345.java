package leetcode.doublepointer;

/*
    注意点：
    字符转化为小写Character.toLowerCase
    String的indexOf可以判断字符在不在字符串中
    题目描述：
    编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
    思路：
    1. 第一次扫描，将元音字母存到数组中,第二次扫描替换元音字母。时间复杂度O(2n)
    2. 双指针，一个从前往后一个从后往前，前后指针都指向元音字母且两个指针不相等时，交换。时间复杂度O(n)
 */

import util.*;

public class LeetCode345 {
    public static void main(String[] args){
        System.out.println(reverseVowels1("lcd"));
    }
    //思路1
    public static String reverseVowels(String s) {
        if (s==null){
            return null;
        }
        StringBuilder oldStr = new StringBuilder(s);
        String vowel = "aeiou";
        char[] vowelChar = new char[oldStr.length()];
        int indexOfVowel = 0;
        //第一次扫描，将元音字母存到数组中
        for (int i = 0; i < oldStr.length(); i++) {
            //是元音字母
            if(vowel.indexOf(Character.toLowerCase(oldStr.charAt(i)))!=-1){
                vowelChar[indexOfVowel++] = oldStr.charAt(i);
            }
        }
        //第二次扫描替换元音字母
        for (int i = 0; i < oldStr.length(); i++) {
            //是元音字母
            if(vowel.indexOf(Character.toLowerCase(oldStr.charAt(i)))!=-1){
                oldStr.setCharAt(i,vowelChar[--indexOfVowel]);
            }
        }
        return oldStr.toString();
    }
    //思路2
    public static String reverseVowels1(String s) {
        StringBuilder newString = new StringBuilder(s);
        int left = 0;
        int right = s.length()-1;
        String vowel = "aeiou";
        while (true){
            //找左边的元音字母
            while (left<newString.length() && vowel.indexOf(Character.toLowerCase(newString.charAt(left)))==-1){
                left++;
            }
            //找右边的元音字母
            while (right>0 && vowel.indexOf(Character.toLowerCase(newString.charAt(right)))==-1){
                right--;
            }
            if(left<right){
                //交换
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
