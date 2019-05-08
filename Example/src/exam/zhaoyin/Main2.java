package exam.zhaoyin;

/*
    100%
    µ¹Ë®
 */
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long w = scanner.nextLong();
        long[] a = new long[2*(int)n];
        for (int i = 0; i < 2*n; i++) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        double x1 = w/(3.0*n);
        double x2 = a[0];
        double x3 = a[(int)n]/2.0;
        double result = Math.min(x1,Math.min(x2,x3))*3.0*n;
        System.out.println(String.format("%.6f", result));
    }
}
