package exam.tengxun;

import java.util.*;

/*
    4月5号
    注意点：
    1. 注意输入参数的范围，看int够不够存
 */
/**
 * 没做出来
    问题描述：
    找零问题
    第一行输入m,n。n为硬币面值数，需要带尽量少的硬币并且能组合出1到m（包括1和m）所有面值
    后面n行，表示面值数
    输出最小需要携带的硬币数
    思路：
    //贪心
    下一个加入的硬币的面值为 小于等于现在能组成的面值+1 的最大面值的硬币
 */
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] mianzhi = new int[n];
        int coinNum = 0;
        for (int i = 0; i < n; i++) {
            mianzhi[i] = scanner.nextInt();
        }
        System.out.println(oneToMMinNumOfCoin(mianzhi,m));

    }

    /**
     * 输出可组成1~m所有面值所需的最小硬币数
     * @param mianzhi
     * @param m
     * @return
     */
    static int oneToMMinNumOfCoin(int[] mianzhi,int m){
        Arrays.sort(mianzhi);
        //没有面值为1的硬币，输出-1
        if(mianzhi[0]!=1){
            return -1;
        }
        //现在指向硬币面值的索引
        int cur = 0;
        //现在能组成的面值
        int now = 0;
        //现在的硬币数
        int numOfCoin = 0;
        while (now<m){
            while (cur<mianzhi.length-1 && mianzhi[cur+1]<=now+1){
                cur++;
            }
            now += mianzhi[cur];
            numOfCoin++;
        }
        //用for循环
//        for (int i = 1; i <= m; i++) {
//            //现在的硬币足够了
//            if(now>=i){
//                continue;
//            }else {     //硬币不够，加入能加入的最大的硬币
//                while (cur<mianzhi.length-1 && mianzhi[cur+1]<=now+1){
//                    cur++;
//                }
//                now+=mianzhi[cur];
//                numOfCoin++;
//            }
//        }
        return numOfCoin;
    }

    /**
     * 输出了组成m所需的最小硬币数，和题目要求不一样
     * @param mianzhi
     * @param m
     * @return
     */
    static int minNumOfCoin(int[] mianzhi,int m){
        int coinNum=0;
        int i = mianzhi.length-1;
        while (m!=0 && i!=-1){
            coinNum += m/mianzhi[i];
            m = m%mianzhi[i--];
        }
        if (m==0){
            return coinNum;
        }else {
            return -1;
        }
    }
}
