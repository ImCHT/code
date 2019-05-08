package leetcode.search.dfs;

/*
    题目描述：
    给含了一些 0 和 1的非空二维数组 grid , 一个岛屿 是由四个方向 (水平或垂直)的1(代表土地)构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
    找到给定的二维定一个包数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
    思路：
    深度优先搜索，可达性
 */
public class LeetCode695 {
    public static void main(String[] args){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                     {0,1,1,0,1,0,0,0,0,0,0,0,0},
                     {0,1,0,0,1,1,0,0,1,0,1,0,0},
                     {0,1,0,0,1,1,0,0,1,1,1,0,0},
                     {0,0,0,0,0,0,0,0,0,0,1,0,0},
                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                     {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    private static int m,n;
    private static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea,dfs(grid,i,j));
            }
        }
        return maxArea;
    }
    private static int dfs(int[][] grids,int row,int col){
        if(row<0 || row>=m || col<0 || col>=n || grids[row][col]==0){
            return 0;
        }
        grids[row][col] = 0;
        int area = 1;
        for (int[] d:direction){
            area += dfs(grids,row+d[0],col+d[1]);
        }
        return area;
    }
}
