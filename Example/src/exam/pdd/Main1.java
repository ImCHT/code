package exam.pdd;

/*
    4��3��
    ��Ŀ������
    ����һ������Ϊż��������arr�����������е�����������Բ���ͣ�����Щ����ѡ��������Сֵ���ʸ����������ԣ����������ֵ����Сֵ�Ĳ�ֵ��С
    ��һ��Ϊһ������n��2<=n<=10000���ڶ���Ϊn���������Ŀ�����飬ÿ�������ڵ���2��С�ڵ���100��
    �����С�Ĳ�ֵ
    ˼·��
    �������������������Ӧλ����ӣ��ҳ�������С��ֵ��Ϊ����
 */
import java.util.*;

//��С�Ĳ�ֵ
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Integer sum = 0;
        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list);
        Integer max = 1;
        Integer min = 1001;
        for (int i = 0; i < N/2; i++) {
            sum = list.get(i)+list.get(N-1-i);
            if (sum>max){
                max = sum;
            }
            if(sum<=min){
                min = sum;
            }
        }
        System.out.println(max-min);
    }
}

