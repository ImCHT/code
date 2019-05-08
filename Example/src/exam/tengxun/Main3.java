package exam.tengxun;

//80%
/**
    题目描述：
    打怪兽，依次遇到怪兽
    第一行为怪兽个数
    后续一行为怪兽武力值
    后续一行为贿赂所需金币数，金币数不是1就是2
    输出需要最少携带的金币数
    思路：
    1. 80%，直到打不过的时候再买
    2. 分成四种情况。题目能过
    3. dfs+剪枝。不会
 */
import java.util.*;
public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] wuli = new int[len];
        int[] money = new int[len];
        int wuliZhi = 0;
        int cost = 0;
        for (int i = 0; i < len; i++) {
            wuli[i] = scanner.nextInt();
        }
        for (int i = 0; i < len; i++) {
            money[i] = scanner.nextInt();
        }
        //上面是输入
        //思路2：大顶堆。也有bug
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2){
                    return -1;
                }else if(o1<o2){
                    return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < len; i++) {
            //过得了，金币为1。放入大顶堆
            if (wuliZhi>=wuli[i] && money[i]==1){
                priorityQueue.add(wuli[i]);
            }else if(wuliZhi>=wuli[i] && money[i]==2){//过得了，金币为2。不管

            }else if(wuliZhi<wuli[i] && money[i]==1){//过不了，金币为1。买
                cost+=money[i];
                wuliZhi+=wuli[i];
            }else if(wuliZhi<wuli[i] && money[i]==2){//过不了，金币为2。看买了大顶堆的能不能过，能过就买大顶堆。不行买这个
                if (priorityQueue.size()!=0 && priorityQueue.peek()+wuliZhi>wuli[i]){
                    cost+=1;
                    priorityQueue.poll();
                }else {
                    cost+=money[i];
                    wuliZhi+=wuli[i];
                }
            }
        }
        System.out.println(cost);
        //80% 思路1
//        for (int i = 0; i < len; i++) {
//            //不买过不了
//            if(wuliZhi<wuli[i]){
//                cost+=money[i];
//                wuliZhi+=wuli[i];
//            }
//        }
//        System.out.println(cost);
    }
}
