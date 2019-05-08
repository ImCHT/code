package algorithm;

public class DFS {
    private int m, n;
    private int[][] matrix;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static void dfs(char[][] grid,int row,int col){
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
