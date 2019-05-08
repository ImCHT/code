package leetcode.doublepointer;

/*
    注意点：
    要注意举例子，考虑特殊情况
    题目描述：
    给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
    改进：
    删除字符数可以改变,可以的，递归+或运算
    思路：
    1. 左右指针，不断对比，看是否相等，第一次遇到不相等时，左右分别偏移一位试试，看是否相等，第二次不等输出false
       若到了left>=right返回true。错误，没有考虑特殊情况
    2. 递归两种情况用或连接
 */
public class LeetCode680 {
    public static void main(String[] args){
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
    public static boolean validPalindrome(String s){
        return validPalindromeTime(s,1);
    }
    public static boolean validPalindromeTime(String s,int time) {
        if(s==null){
            return false;
        }
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
//                System.out.println(s.substring(left,right+1));
            }else if(time>0){
                return validPalindromeTime(s.substring(left+1,right+1),time-1) || validPalindromeTime(s.substring(left,right),time-1);
                //左边跳过一个
//                if(s.charAt(left+1)==s.charAt(right)){
//                    left++;
//                    times--;
//                }else if(s.charAt(left)==s.charAt(right-1)){    //右边跳过一个
//                    right--;
//                    times--;
//                }else{//左右都没有匹配的
//                    return false;
                }else {
                return false;
            }
        }
        return true;
    }
}
