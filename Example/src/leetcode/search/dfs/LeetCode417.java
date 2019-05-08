package leetcode.search.dfs;
/*
    题目描述：
    给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，
    而“大西洋”处于大陆的右边界和下边界。
    规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
    请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
    思路：
    1. 需要深度优先搜索的节点：四周的节点；深度优先搜索时对节点的操作：判断是否到了另一边，判断是否能向四周节点dfs
    2. 左上和右下的节点分别设个标记数组，分别进行深度优先搜索，搜索公共被标记的节点就是联通节点。四周节点到这个节点时，进行标记
    注意点：
    对集合类对象存放基本数据类型的数组时，判断是否包含，不能用contains会比较地址而不是值
    直接新建数组 new int[]{1,2}
 */
import java.util.*;
public class LeetCode417 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<int[]> list = new LeetCode417().pacificAtlantic(matrix);
        for (int[] array:list) {
            for (int num: array) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    private int m, n;
    private int[][] matrix;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }

        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    ret.add(new int[]{i, j});
                }
            }
        }

        return ret;
    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || matrix[r][c] > matrix[nextR][nextC]) {   //这里是大于，不能过去。不是你能去，而是它能过来
                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }
    /*自己写的，没通过
        public static List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> list = new ArrayList<>();
            List<int[]> tempList = new ArrayList<>();
            int m = matrix.length,n = matrix[0].length;
            boolean[] reachable = new boolean[1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //左上部分
                    if (i==0 || j==0){
                        tempList = DFS1(matrix,i,j,tempList,reachable);
                        for (int[] temp:tempList) {
                            boolean isContained = false;
                            for (int[] array:list) {
                                if (Arrays.equals(array,temp)){
                                    isContained = true;
                                    break;
                                }
                            }
                            if (!isContained){
                                list.add(temp);
                            }
                        }
                        tempList.clear();
                        reachable[0] = false;
                    }
                    //右下部分
                    if (i==m-1 || j==n-1){
                        tempList = DFS2(matrix,i,j,tempList,reachable);
                        for (int[] temp:tempList) {
                            boolean isContained = false;
                            for (int[] array:list) {
                                if (Arrays.equals(array,temp)){
                                    isContained = true;
                                    break;
                                }
                            }
                            if (!isContained){
                                list.add(temp);
                            }
                        }
                        tempList.clear();
                        reachable[0] = false;
                    }
                }
            }
            return list;
        }
        //左上部分
        private static List<int[]> DFS1(int[][] martix,int i,int j,List<int[]> tempList,boolean[] reachable){
            int[] cord = {i,j};
            //坐标非法
            if (i<0 || i>=martix.length || j<0 || j>=martix[0].length){
                return tempList;
            }
            //查看是否已被遍历过
            for (int[] temp:tempList) {
                if (Arrays.equals(temp,cord)){
                    return tempList;
                }
            }
            tempList.add(cord);
            //到达了右下部分
            if (i==martix.length-1 || j==martix[0].length-1){
                reachable[0] = true;
    //            return tempList;
            }
            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
            for (int[] direction:directions) {
                int[] newCord = {i+direction[0],j+direction[1]};
                if (newCord[0]>=0 && newCord[0]<martix.length && newCord[1]>=0 && newCord[1]<martix[0].length && martix[newCord[0]][newCord[1]]<=martix[i][j]){
                    DFS1(martix,newCord[0],newCord[1],tempList,reachable);
                }
            }
            //扫描到最后还没找到出口，说明这个坐标不可达右下角，删除
            if (reachable[0]){
                return tempList;
            }else {
                tempList.remove(cord);
                return tempList;
            }
        }
        //右下部分
        private static List<int[]> DFS2(int[][] martix,int i,int j,List<int[]> tempList,boolean[] reachable){
            int[] cord = {i,j};
            //坐标非法
            if (i<0 || i>=martix.length || j<0 || j>=martix[0].length){
                return tempList;
            }
            //查看是否已被遍历过
            for (int[] temp:tempList) {
                if (Arrays.equals(temp,cord)){
    //                return tempList;
                }
            }
            tempList.add(cord);
            //到达了左上部分
            if (i==0 || j==0){
                reachable[0] = true;
                return tempList;
            }
            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
            for (int[] direction:directions) {
                int[] newCord = {i+direction[0],j+direction[1]};
                if (newCord[0]>=0 && newCord[0]<martix.length && newCord[1]>=0 && newCord[1]<martix[0].length && martix[newCord[0]][newCord[1]]<=martix[i][j]){
                    DFS2(martix,newCord[0],newCord[1],tempList,reachable);
                }
            }
            //扫描到最后还没找到出口，说明这个坐标不可达右下角，删除
            if (reachable[0]){
                return tempList;
            }else {
                tempList.remove(cord);
                return tempList;
            }
        }
    */
}
