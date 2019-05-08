package leetcode.search.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/*
     ��Ŀ������
     �����������д�ԭ�㵽�ض�������·������
     [[1,1,0,1],
     [1,0,1,0],
     [1,1,1,1],
     [1,0,1,1]]
     1��ʾ���Ծ���ĳ��λ�ã�����(0,0)λ�õ�(tr,tc)λ�õ����·�����ȡ�
 */
public class MinPathLength {
    public static void main(String[] args){
        int[][] grids = {{1,1,0,1},{1,0,1,0},{1,1,1,1},{1,0,1,1}};
        System.out.println(minPathLength(grids,4,3));
    }
    //BFSѰ�����·��
    public static int minPathLength(int[][] grids,int tr,int tc){
        final int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength = 0;
        //ÿ�㶼��������
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            //ĳһ����б�������һ��
            while (size-->0){
                Pair<Integer,Integer> cur = queue.poll();
                int cr = cur.getKey(),cc = cur.getValue();
                grids[cr][cc] = 0;  //���
                for (int[] d:direction) {
                    int nr = cr+d[0],nc = cc+d[1];
                    if (nr<0 || nr>=m || nc<0 || nc>=n || grids[nr][nc]==0){
                        continue;
                    }
                    if (nr==tr && nc==tc){
                        return pathLength;
                    }
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return -1;
    }
}
