package leetcode.search.backtracking;

/*
    题目描述：
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    思路：
    1. 多重循环。不能根据外部输入控制循环的层次，不可取
    2. 回溯法。dfs返回后需要清除标记
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
        //特殊输入
        if (digits==null || digits.length()==0){
            return list;
        }
        //清除输入中的非法输入，除了2~9
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
    //回溯法，递归返回时需要清除标记
    private static void dfs(List<String> list,String digits,StringBuilder tempStr){
        //tempStr长度和数字的长度一样，返回
        if (tempStr.length()==digits.length()){
            list.add(tempStr.toString()); //toString方法会返回一个新的对象
//            tempStr.deleteCharAt(tempStr.length()-1);
            return;
        }
        String keyString = KEYS[digits.charAt(tempStr.length())-'0'];
        for (char c:keyString.toCharArray()) {
            tempStr.append(c);  //加入字符
            dfs(list,digits,tempStr);
            tempStr.deleteCharAt(tempStr.length()-1);  //回溯法
        }
    }
}
