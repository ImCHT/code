package leetcode.doublepointer;

import java.util.Arrays;
import java.util.List;

/*
    ��Ŀ������
    ����һ���ַ�����һ���ַ����ֵ䣬�ҵ��ֵ���������ַ��������ַ�������ͨ��ɾ�������ַ�����ĳЩ�ַ����õ���
    ����𰸲�ֹһ�������س�������ֵ�˳����С���ַ���������𰸲����ڣ��򷵻ؿ��ַ�����
    ע��㣺
    1. String b = "123";
       String c = new String("123");
       ͨ����==���Ƚ�ʱ��b��c��ַʱ�����
    2. �ֵ�˳����С��a.compareTo(b) ��a���ֵ�˳��С��b�Ļ�����0
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
    //�ж��ַ���a���Ƿ�����ַ���b
    static  boolean isContained(String a,String b){
        //����ַ���A�ĳ���С���ַ���B�ĳ��ȣ�����false
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
