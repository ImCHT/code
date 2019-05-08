package leetcode.search.dfs;

/*
    ��Ŀ����������Ȧ
    ������ N ��ѧ����������Щ�������ѣ���Щ���ǡ����ǵ���������Ǵ����ԡ������֪ A �� B �����ѣ�B �� C �����ѣ�
    ��ô���ǿ�����Ϊ A Ҳ�� C �����ѡ���ν������Ȧ����ָ�������ѵļ��ϡ�
    ����һ�� N * N �ľ��� M����ʾ�༶��ѧ��֮������ѹ�ϵ�����M[i][j] = 1����ʾ��֪�� i ���� j ��ѧ����Ϊ���ѹ�ϵ��
    ����Ϊ��֪����������������ѧ���е���֪������Ȧ������
    ˼·��
    ����һ������֮������������������������ܷ��ʵ��ĳ���
 */
public class LeetCode547 {
    public static void main(String[] args){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(findCircleNum(grid));
    }
    public static int findCircleNum(int[][] M) {
        if (M==null || M.length==0){
            return 0;
        }
        boolean[] isVisited = new boolean[M.length];
        int num = 0;
        for (int i = 0; i < M.length; i++) {
            if(!isVisited[i]){
                num++;
                dfs(M,isVisited,i);
            }
        }
        return num;
    }
    private static void dfs(int[][] M,boolean[] isVisited,int i){
        if (isVisited[i]){
            return;
        }
        isVisited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j]==1){
                dfs(M,isVisited,j);
            }
        }
    }
}
