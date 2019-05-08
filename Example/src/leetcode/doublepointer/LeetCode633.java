package leetcode.doublepointer;
/*
    注意点：
    0也是整数
    int(32位)：范围-2147483648~2147483647。a和b的范围要定义为long,输入c有2147483646
    题目描述：
    给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
    思路：
    1. 两次for循环，外循环代表a,内循环代表b,都从1开始直到超过c。时间复杂度O(n2)
    2. 单单b从下开始增加，直到平方大于c，再用双指针。时间复杂度O(n)
 */
public class LeetCode633 {
    public static void main(String[] args){
        System.out.println(judgeSquareSum(2147483646));
    }
    //第二个思路
    public static boolean judgeSquareSum(int c) {
        long a = 0;
        long b = 0;
        while (b*b<c){
            b++;
        }
        while (a<=b){
            if(a*a+b*b>c){
                b--;
            }else if(a*a+b*b<c){
                a++;
            }else{  //找到了
                return true;
            }
        }
        return false;
    }
}
