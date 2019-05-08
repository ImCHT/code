package exam.meituan;


/**
 *   4.23
 *   题目描述：
 我们称一个矩阵为黑白矩阵，当且仅当对于该矩阵中每一个位置如(i,j),其上下左右四个方向的数字相等，即(i-1,j),(i+1,j),(i,j+1),
 (i,j-1)四个位置上的数字两两相等且均不等于(i,j)位置上的数字。(超出边界的格子忽略)
 现在给出一个n*m的矩阵，我们想通过修改其中的某些数字，使得该矩阵成为黑白矩阵，问最少修改多少个数字。
 输入:
 第一行包含两个整数n,m,表示矩阵的长宽。(1≤n,m≤100000,1≤n*m≤100000)。
 接下来有n行，每行包含m个整数，中间用空格隔开，表示n*m的矩阵。
 输出:
 输出仅包含一个数字，表示该矩阵想修改为黑白矩阵最少修改的数字数量。
 */
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

    }
}
