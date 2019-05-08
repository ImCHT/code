package exam.pdd;

/*
    4月3号
    题目描述：
    给定一个长度为偶数的数组arr，将该数组中的数字两两配对并求和，在这些和中选出最大和最小值，问该如何两两配对，才能让最大值和最小值的差值最小
    第一行为一个整数n，2<=n<=10000，第二行为n个数，组成目标数组，每个数大于等于2，小于等于100。
    输出最小的差值
    思路：
    排序，最左和最右两两对应位置相加，找出最大和最小差值即为所求
 */
import java.util.*;

//最小的差值
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

