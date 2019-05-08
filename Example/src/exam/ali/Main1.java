package exam.ali;

/*
    4.13
    题目描述：
    小明是一个数学家，他喜欢用数字给事物命名编号，他给自己编号为1，同时在2019年小明开办了一个农场，准备开始养母猪，
    他专门给农场的母猪用以下数列2，3，4，5，7，9，12，16，21，28，37，49，65，86，114，151...进行命名。假设农场
    的母猪永远不会死，小母猪出生后3年后成熟，成熟后从第三年开始每年只会生一只小母猪。第一年农场，有一只刚刚出生的小
    母猪和一只成熟的母猪(本年不再生小猪，下一年开始生小猪)，并给他们编号为2和3。请问，第m只母猪编号为多少？其是哪一
    年出生的？小明还准备了1份礼物，专门颁给农场第1到m只的母猪颁奖，颁奖规则如下:选出第1到m只的母猪翻转编号(114编号翻
    转为411)为第k大的母猪进行颁奖，请问是第几只猪获奖？提示: f(n)=f(n-2)+f(n-3)
    输入:
    输入两个参数半角逗号分隔
    m,k
    输出:
    输出三个数字半角逗号分隔
    第m只母猪编号,哪一年出生,第几只小猪获奖
    输入范例:
    20,3
    输出范例:
    465,2024,15
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {

    /* 请完成下面这个函数，实现题目要求的功能 **/
    /* 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String calculate(int m, int k) {
        return null;
    }
    //先算出一只成熟的猪，n年后所有猪的数量
    static int numOfPig1(int n){
       int[] num = new int[n];
       num[0] = 1;
       num[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            num[i] = num[i-1]+num[i-2];
        }
        return num[n];
    }
    //刚开始一只刚生的猪，n年后的数量
    static int numOfPig2(int n){
        if (n<3){
            return 1;
        }else {
            return numOfPig1(n-3);
        }
    }
    //总的数量:两个加起来
    static int numOfPig3(int n){
        return numOfPig1(n)+numOfPig2(n);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}
