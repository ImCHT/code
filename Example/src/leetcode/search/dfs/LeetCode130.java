package leetcode.search.dfs;

/*
    题目描述：
    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
    思路：
    任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'
    需要深度优先遍历的对象：边界上的'0',并标记为'1'
 */
public class LeetCode130 {
    public static void main(String[] args){

    }
    public static void solve(char[][] board) {
        if (board==null || board.length==0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        //搜索边界中值为'O'的节点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        //将没有被标记位'1'的'0',改为'X',且将‘1’改回‘0’。确定要dfs的节点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='1'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private static void dfs(char[][] board,int i,int j){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O'){
            return;
        }
        board[i][j] = '1';
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] direction:directions) {
            dfs(board,i+direction[0],j+direction[1]);
        }
    }
}
