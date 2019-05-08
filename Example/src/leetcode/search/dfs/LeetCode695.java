package leetcode.search.dfs;

/*
    ��Ŀ������
    ������һЩ 0 �� 1�ķǿն�ά���� grid , һ������ �����ĸ����� (ˮƽ��ֱ)��1(��������)���ɵ���ϡ�����Լ����ά������ĸ���Ե����ˮ��Χ�š�
    �ҵ������Ķ�ά��һ�������������ĵ��������(���û�е��죬�򷵻����Ϊ0��)
    ˼·��
    ��������������ɴ���
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
