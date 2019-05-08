package leetcode.search.backtracking;

/*
    题目描述：
    给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
    思路：
    回溯法，3次回溯
 */
import util.Utility;

import java.util.*;

public class LeetCode93 {
    public static void main(String[] args){
        List<String> list;
        list = restoreIpAddresses("010010");
        for (String str:
             list) {
            System.out.println(str);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        //特殊情况
        if (s==null || s.length()==0 || s.length()>12){
            return list;
        }
        int leftIndex = 0;
        StringBuilder tempStr = new StringBuilder();
        dfs(s,leftIndex,tempStr,list);
        return list;
    }
    //0后面不能跟数字
    private static void dfs(String s,int leftIndex,StringBuilder tempStr,List<String> list){
        //出口条件
        //1.到了末尾
        if (leftIndex>=s.length()){
            return;
        }
        //2.到了最后一段的ip
        if (Utility.aContaninsBNum(tempStr.toString(),".")==3){

            if (s.charAt(tempStr.length()-3)=='0' && leftIndex!=s.length()-1){
                return;
            }
            long ip4 = Long.parseLong(s.substring(tempStr.length()-3));
            if (ip4>=0 && ip4<=255){
                tempStr.append(ip4);
                list.add(tempStr.toString());
                //清除这一层的变化
                tempStr.delete(leftIndex+3,tempStr.length());
                return;
            }else {
                return;
            }
        }
        int index = leftIndex;
        for (int i = leftIndex; i < s.length(); i++) {
            if (s.charAt(leftIndex)=='0' && i!=leftIndex){
                break;
            }
            int num = Integer.parseInt(s.substring(leftIndex,i+1));
            if (num>=0 && num<=255){
                tempStr.append(s.substring(leftIndex,i+1)+".");
                leftIndex = i+1;
                dfs(s,leftIndex,tempStr,list);
                leftIndex = index;
                tempStr.delete(tempStr.length()-i+leftIndex-2,tempStr.length());
            }else {
                break;
            }
        }
    }
}
