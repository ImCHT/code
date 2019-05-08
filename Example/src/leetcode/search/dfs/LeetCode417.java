package leetcode.search.dfs;
/*
    ��Ŀ������
    ����һ�� m x n �ķǸ�������������ʾһƬ��½�ϸ�����Ԫ��ĸ߶ȡ���̫ƽ�󡱴��ڴ�½����߽���ϱ߽磬
    ���������󡱴��ڴ�½���ұ߽���±߽硣
    �涨ˮ��ֻ�ܰ����ϡ��¡������ĸ�������������ֻ�ܴӸߵ��ͻ�����ͬ�ȸ߶���������
    ���ҳ���Щˮ���ȿ�����������̫ƽ�󡱣������������������󡱵�½�ص�Ԫ�����ꡣ
    ˼·��
    1. ��Ҫ������������Ľڵ㣺���ܵĽڵ㣻�����������ʱ�Խڵ�Ĳ������ж��Ƿ�����һ�ߣ��ж��Ƿ��������ܽڵ�dfs
    2. ���Ϻ����µĽڵ�ֱ����������飬�ֱ�����������������������������ǵĽڵ������ͨ�ڵ㡣���ܽڵ㵽����ڵ�ʱ�����б��
    ע��㣺
    �Լ���������Ż����������͵�����ʱ���ж��Ƿ������������contains��Ƚϵ�ַ������ֵ
    ֱ���½����� new int[]{1,2}
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
                    || matrix[r][c] > matrix[nextR][nextC]) {   //�����Ǵ��ڣ����ܹ�ȥ����������ȥ���������ܹ���
                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }
    /*�Լ�д�ģ�ûͨ��
        public static List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> list = new ArrayList<>();
            List<int[]> tempList = new ArrayList<>();
            int m = matrix.length,n = matrix[0].length;
            boolean[] reachable = new boolean[1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //���ϲ���
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
                    //���²���
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
        //���ϲ���
        private static List<int[]> DFS1(int[][] martix,int i,int j,List<int[]> tempList,boolean[] reachable){
            int[] cord = {i,j};
            //����Ƿ�
            if (i<0 || i>=martix.length || j<0 || j>=martix[0].length){
                return tempList;
            }
            //�鿴�Ƿ��ѱ�������
            for (int[] temp:tempList) {
                if (Arrays.equals(temp,cord)){
                    return tempList;
                }
            }
            tempList.add(cord);
            //���������²���
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
            //ɨ�赽���û�ҵ����ڣ�˵��������겻�ɴ����½ǣ�ɾ��
            if (reachable[0]){
                return tempList;
            }else {
                tempList.remove(cord);
                return tempList;
            }
        }
        //���²���
        private static List<int[]> DFS2(int[][] martix,int i,int j,List<int[]> tempList,boolean[] reachable){
            int[] cord = {i,j};
            //����Ƿ�
            if (i<0 || i>=martix.length || j<0 || j>=martix[0].length){
                return tempList;
            }
            //�鿴�Ƿ��ѱ�������
            for (int[] temp:tempList) {
                if (Arrays.equals(temp,cord)){
    //                return tempList;
                }
            }
            tempList.add(cord);
            //���������ϲ���
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
            //ɨ�赽���û�ҵ����ڣ�˵��������겻�ɴ����½ǣ�ɾ��
            if (reachable[0]){
                return tempList;
            }else {
                tempList.remove(cord);
                return tempList;
            }
        }
    */
}
