package leetcode.search.dfs;

/*
    题目描述：朋友圈
    班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
    那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
    给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
    否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
    思路：
    访问一个城市之后，深度优先搜索，访问所有能访问到的城市
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
