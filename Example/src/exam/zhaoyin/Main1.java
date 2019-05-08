package exam.zhaoyin;

//4月9号
/*
    100%
    分巧克力
 */
import java.math.BigInteger;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 6) {
            System.out.println(0);
        } else {
            BigInteger b = new BigInteger("2");
            BigInteger ans = b.pow(n-6);
            if (ans.compareTo(new BigInteger("666666666"))==1){
                ans = ans.mod(new BigInteger("666666666"));
            }
            System.out.println(ans.toString());
        }
    }
}


