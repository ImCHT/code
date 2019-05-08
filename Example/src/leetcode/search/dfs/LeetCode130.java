package leetcode.search.dfs;

/*
    ��Ŀ������
    ����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O����
    �ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ��䡣
    ˼·��
    �κβ��ڱ߽��ϣ�����߽��ϵ� 'O' ������ 'O' ���ն��ᱻ���Ϊ 'X'
    ��Ҫ������ȱ����Ķ��󣺱߽��ϵ�'0',�����Ϊ'1'
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
        //�����߽���ֵΪ'O'�Ľڵ�
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        //��û�б����λ'1'��'0',��Ϊ'X',�ҽ���1���Ļء�0����ȷ��Ҫdfs�Ľڵ�
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
