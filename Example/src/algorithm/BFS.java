package algorithm;

import javafx.util.Pair;

import java.util.*;

public class BFS {
    //BFSѰ�����·��
    static int minPathLength(int[][] grids,int tr,int tc){
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