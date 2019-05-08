package algorithm;

import javafx.util.Pair;

import java.util.*;

public class BFS {
    //BFS寻找最短路径
    static int minPathLength(int[][] grids,int tr,int tc){
        final int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength = 0;
        //每层都遍历完了
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            //某一层进行遍历到下一层
            while (size-->0){
                Pair<Integer,Integer> cur = queue.poll();
                int cr = cur.getKey(),cc = cur.getValue();
                grids[cr][cc] = 0;  //标记
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
