package leetcode.search.dfs;

/*
    题目描述：岛屿的个数
    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向
    上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 */
public class LeetCode200 {
    public static void main(String[] args){
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        int row = grid.length,col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]=='1'){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }
    private static void dfs(char[][] grid,int row,int col){
        if (row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0'){
            return;
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        grid[row][col] = '0';
        for (int[] direction:directions) {
            int curRow = row+direction[0],curCol = col+direction[1];
            dfs(grid,curRow,curCol);
        }
    }
}
