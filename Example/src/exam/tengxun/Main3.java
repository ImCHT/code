package exam.tengxun;

//80%
/**
    ��Ŀ������
    ����ޣ�������������
    ��һ��Ϊ���޸���
    ����һ��Ϊ��������ֵ
    ����һ��Ϊ��¸�������������������1����2
    �����Ҫ����Я���Ľ����
    ˼·��
    1. 80%��ֱ���򲻹���ʱ������
    2. �ֳ������������Ŀ�ܹ�
    3. dfs+��֦������
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
        //����������
        //˼·2���󶥶ѡ�Ҳ��bug
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
            //�����ˣ����Ϊ1������󶥶�
            if (wuliZhi>=wuli[i] && money[i]==1){
                priorityQueue.add(wuli[i]);
            }else if(wuliZhi>=wuli[i] && money[i]==2){//�����ˣ����Ϊ2������

            }else if(wuliZhi<wuli[i] && money[i]==1){//�����ˣ����Ϊ1����
                cost+=money[i];
                wuliZhi+=wuli[i];
            }else if(wuliZhi<wuli[i] && money[i]==2){//�����ˣ����Ϊ2�������˴󶥶ѵ��ܲ��ܹ����ܹ�����󶥶ѡ����������
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
        //80% ˼·1
//        for (int i = 0; i < len; i++) {
//            //���������
//            if(wuliZhi<wuli[i]){
//                cost+=money[i];
//                wuliZhi+=wuli[i];
//            }
//        }
//        System.out.println(cost);
    }
}
