package exam.tengxun;

//100%
/**
    题目描述：
    给定一个仅含0和1的字符串，若1和0相邻就可以删除这两个字符，
    输出字符串，输出消除后所剩字符串的长度
    思路：
    遍历，得到字符0和1的数量，输出差的绝对值
 */
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String str = scanner.next();
        int numOfZero = 0;
        int numOfOne = 0;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i)=='0'){
                numOfZero++;
            }else {
                numOfOne++;
            }
        }
        System.out.println(Math.abs(numOfOne-numOfZero));
    }

}
