package leetcode.search.dfs;

/*
    ��Ŀ����������ĸ���
    ����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά���񣬼��㵺���������һ������ˮ��Χ����������ͨ��ˮƽ�����ֱ����
    �����ڵ�½�����Ӷ��ɵġ�����Լ���������ĸ��߾���ˮ��Χ��
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
