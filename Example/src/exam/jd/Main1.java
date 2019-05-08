package exam.jd;

/*
    题目描述：
    体育场突然着火了，现场需要紧急疏散，但是过道真的是太窄了，同时只能容许一个人通过。现在知道了体育场的所有座位分布，
    座位分布图是一棵树，已知每个座位上都坐了一个人，安全出口在树的根部，也就是1号结点的位置上。其他节点上的人每秒都能
    向树根部前进一个结点，但是除了安全出口以外，没有任何一个结点可以同时容纳两个及以上的人，这就需要一种策略，来使得
    人群尽快疏散，问在采取最优策略的情况下，体育场最快可以在多长时间内疏散完成。
    输入：
    第一行包含一个正整数n，即树的结点数量（1<=n<=100000）。
    接下来有n-1行，每行有两个正整数x，y，表示在x和y结点之间存在一条边。(1<=x<=y<=n)
    输出：
    输出仅包含一个正整数，表示所需要的最短时间
    样例输入
    6
    2 1
    3 2
    4 3
    5 2
    6 1
    样例输出
    4
 */
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StringBuilder> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n-1; i++) {
            String j = scanner.next();  //大的
            String k = scanner.next();  //小的
            //加入新的子树
            if (k.equals("1")){
                StringBuilder stringBuilder = new StringBuilder(j);
                list.add(stringBuilder);
            }else { //否则在之前里面找
                for (StringBuilder str:list) {
                    if (str.indexOf(k)!=-1){
                        str.append(j);
                        break;
                    }
                }
            }
        }
        int result = 0;
        for (StringBuilder str:list) {
            if (str.length()>result){
                result = str.length();
            }
        }
        System.out.println(result);
    }
}
