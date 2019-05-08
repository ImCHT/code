package leetcode.search.bfs;

import java.util.*;

/*
    ��Ŀ������
    ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n��
    ����Ҫ����ɺ͵���ȫƽ�����ĸ������١�
    ˼·��
    1. �����������
        �ڵ㺬�壺������n��ʣ��ֵ
        ÿ�ζԽڵ���еĲ������ڵ��ȥÿһ�����ܵ���ȫƽ���������С��0�����ѱ�����������������0�������������������
        ��ǣ�������n����ʣ��Ŀ���ֵ
    2. ��̬�滮
        opt���ʽ��min(opt[n-���б�nС����ȫƽ����]+1)��������������ȫƽ��������������1
        ����������opt[1] = 1
 */
public class LeetCode279 {
    public static void main(String[] args){
        System.out.println(numSquares(465465));
    }
    //˼·1��BFS������
    public static int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n+1];
        queue.offer(n);
        marked[n] = true;
        int layerNum = 0;
        //����û�б�����
        while (!queue.isEmpty()){
            layerNum++;
            int size = queue.size();
            //��ÿһ��Ľڵ���д���
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
    //����С��n����ȫƽ�������С�
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
    //˼·2����̬�滮������ʱ�临�Ӷ�O(nlogn)
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
