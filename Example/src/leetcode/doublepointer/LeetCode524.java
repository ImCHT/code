package leetcode.doublepointer;

import java.util.Arrays;
import java.util.List;

/*
    题目描述：
    给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
    如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
    注意点：
    1. String b = "123";
       String c = new String("123");
       通过“==”比较时，b和c地址时不相等
    2. 字典顺序最小，a.compareTo(b) 若a的字典顺序小于b的话返回0
 */
public class LeetCode524 {
    public static void main(String[] args){
        String s = "bab";
        String[] d = {"ba","ab","a","b"};
        List<String> list = Arrays.asList(d);
        System.out.println(findLongestWord(s,list));
    }
    public static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String string:d) {
            if(string.length()<longestWord.length() || (string.length()==longestWord.length() && longestWord.compareTo(string)<0)){
                continue;
            }
            if (isContained(s,string)){
                longestWord = string;
            }
        }
        return longestWord;
    }
    //判断字符串a中是否包含字符串b
    static  boolean isContained(String a,String b){
        //如果字符串A的长度小于字符串B的长度，返回false
//        if(b.length()>a.length()){
//            return false;
//        }
//        if(a.length()==b.length()){
//            return a.equals(b);
//        }
        int index1 = 0;
        int index2 = 0;
        while (index1<a.length() && index2<b.length()){
            if(a.charAt(index1)==b.charAt(index2)){
                index2++;
            }
            index1++;
        }
        return index2==b.length();
    }
}
