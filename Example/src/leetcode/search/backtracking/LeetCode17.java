package leetcode.search.backtracking;

/*
    ��Ŀ������
    ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
    �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
    ˼·��
    1. ����ѭ�������ܸ����ⲿ�������ѭ���Ĳ�Σ�����ȡ
    2. ���ݷ���dfs���غ���Ҫ������
 */
import java.util.*;
public class LeetCode17 {
    public static void main(String[] args){
        List<String> list = letterCombinations("321512451");
        for (String str:list) {
            System.out.println(str);
        }
    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        //��������
        if (digits==null || digits.length()==0){
            return list;
        }
        //��������еķǷ����룬����2~9
        StringBuilder tempDigits = new StringBuilder(digits);
        for (int i = 0; i < tempDigits.length(); i++) {
            if ((tempDigits.charAt(i)<'2') || (tempDigits.charAt(i)>'9')){
                tempDigits.deleteCharAt(i--);
            }
        }
        digits = tempDigits.toString();
        StringBuilder tempStr = new StringBuilder();
        dfs(list,digits,tempStr);
        return list;
    }
    //���ݷ����ݹ鷵��ʱ��Ҫ������
    private static void dfs(List<String> list,String digits,StringBuilder tempStr){
        //tempStr���Ⱥ����ֵĳ���һ��������
        if (tempStr.length()==digits.length()){
            list.add(tempStr.toString()); //toString�����᷵��һ���µĶ���
//            tempStr.deleteCharAt(tempStr.length()-1);
            return;
        }
        String keyString = KEYS[digits.charAt(tempStr.length())-'0'];
        for (char c:keyString.toCharArray()) {
            tempStr.append(c);  //�����ַ�
            dfs(list,digits,tempStr);
            tempStr.deleteCharAt(tempStr.length()-1);  //���ݷ�
        }
    }
}
