package leetcode.doublepointer;
/*
    ע��㣺
    0Ҳ������
    int(32λ)����Χ-2147483648~2147483647��a��b�ķ�ΧҪ����Ϊlong,����c��2147483646
    ��Ŀ������
    ����һ���Ǹ����� c ����Ҫ�ж��Ƿ������������ a �� b��ʹ�� a2 + b2 = c��
    ˼·��
    1. ����forѭ������ѭ������a,��ѭ������b,����1��ʼֱ������c��ʱ�临�Ӷ�O(n2)
    2. ����b���¿�ʼ���ӣ�ֱ��ƽ������c������˫ָ�롣ʱ�临�Ӷ�O(n)
 */
public class LeetCode633 {
    public static void main(String[] args){
        System.out.println(judgeSquareSum(2147483646));
    }
    //�ڶ���˼·
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
            }else{  //�ҵ���
                return true;
            }
        }
        return false;
    }
}
