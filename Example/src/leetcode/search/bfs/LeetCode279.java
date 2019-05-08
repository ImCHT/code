package leetcode.search.bfs;

import java.util.*;

/*
    题目描述：
    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
    你需要让组成和的完全平方数的个数最少。
    思路：
    1. 广度优先搜索
        节点含义：正整数n的剩余值
        每次对节点进行的操作：节点减去每一个可能的完全平方数。如果小于0或者已被标记跳过、如果等于0输出层数、否则加入队列
        标记：正整数n及其剩余的可能值
    2. 动态规划
        opt表达式：min(opt[n-所有比n小的完全平方数]+1)，或者他就是完全平方数，那它就是1
        出口条件：opt[1] = 1
 */
public class LeetCode279 {
    public static void main(String[] args){
        System.out.println(numSquares(465465));
    }
    //思路1：BFS方法。
    public static int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n+1];
        queue.offer(n);
        marked[n] = true;
        int layerNum = 0;
        //看有没有遍历完
        while (!queue.isEmpty()){
            layerNum++;
            int size = queue.size();
            //对每一层的节点进行处理
            while (size-->0){
                int node = queue.poll();
                for (int i:squares) {
                    int nodeAfterHandle = node-i;
                    if (nodeAfterHandle<0 || marked[nodeAfterHandle]){
                        continue;
                    }else if (nodeAfterHandle==0){
                        return layerNum;
                    }
                    marked[nodeAfterHandle] = true;
                    queue.offer(nodeAfterHandle);
                }
            }
        }
        return -1;
    }
    //生成小于n的完全平方数序列。
    public static List<Integer> generateSquares(int n){
        List<Integer> list = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square<=n){
            list.add(square);
            square += diff;
            diff+=2;
        }
        return list;
    }
    //思路2：动态规划方法。时间复杂度O(nlogn)
    public static int numSquares1(int n) {
        List<Integer> squares = generateSquares(n);
        int[] opt = new int[n+1];
        opt[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square:squares) {
                int num = 1;
                if(square<i){
                    num += opt[i-square];
                    if (num<min){
                        min = num;
                    }
                }else if(square==i){
                    min = 1;
                    break;
                }else if(square>i){
                    break;
                }
            }
            opt[i] = min;
        }
        return opt[n];
    }
}
