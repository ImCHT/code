package exam.meituan;


/**
 *   4.23
 *   ��Ŀ������
 ���ǳ�һ������Ϊ�ڰ׾��󣬵��ҽ������ڸþ�����ÿһ��λ����(i,j),�����������ĸ������������ȣ���(i-1,j),(i+1,j),(i,j+1),
 (i,j-1)�ĸ�λ���ϵ�������������Ҿ�������(i,j)λ���ϵ����֡�(�����߽�ĸ��Ӻ���)
 ���ڸ���һ��n*m�ľ���������ͨ���޸����е�ĳЩ���֣�ʹ�øþ����Ϊ�ڰ׾����������޸Ķ��ٸ����֡�
 ����:
 ��һ�а�����������n,m,��ʾ����ĳ���(1��n,m��100000,1��n*m��100000)��
 ��������n�У�ÿ�а���m���������м��ÿո��������ʾn*m�ľ���
 ���:
 ���������һ�����֣���ʾ�þ������޸�Ϊ�ڰ׾��������޸ĵ�����������
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
