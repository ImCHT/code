package algorithm;

import com.sun.org.apache.regexp.internal.RE;

public class DynamicProgram {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(new DynamicProgram().dpOPT1(arr,arr.length-1,5));
    }
    //�������������������ֵ
    //��̬�滮,�ݹ�(ʱ�临�Ӷ�2^n)��
    int OPT(int[] arr,int i){
        if(i==0){
            return arr[0];
        }else if(i==1){
            return Math.max(arr[0],arr[1]);
        }else {
            return Math.max(OPT(arr,i-1),arr[i]+OPT(arr,i-2));
        }
    }
    // �������������������ֵ
    // ��̬�滮��������洢�м�����(ʱ�临�Ӷ�n)
    int dpOPT(int[] arr,int i){
        int[] OPTNums = new int[arr.length];
        OPTNums[0] = arr[0];
        OPTNums[1] = Math.max(arr[0],arr[1]);
        for (int j = 2; j <= i; j++) {
            OPTNums[j] = Math.max(OPTNums[j-2]+arr[j],OPTNums[j-1]);
        }
        return OPTNums[i];
    }
    //�������Ƿ��м���ֵ���Ϊ����ֵ
    //��̬�滮���ݹ�(ʱ�临�Ӷ�2^n)
    boolean OPT1(int[] arr,int i,int s){
        if(arr[i]==s)
            return true;
        if(i==0)
            return arr[i]==s;
        if(arr[i]>s)
            return OPT1(arr,i-1,s);
        return OPT1(arr,i-1,s-arr[i]) || OPT1(arr,i-1,s);
    }
    //�������Ƿ��м���ֵ���Ϊ����ֵ
    //��̬�滮���ǵݹ�(ʱ�临�Ӷ�n)
    boolean dpOPT1(int[] arr,int i,int s){
        boolean[][] OPTNums = new boolean[arr.length][s+1];
        for (int j = 0; j < arr.length; j++) {
            OPTNums[j][0] = true;
        }
        for (int j = 1; j < OPTNums[0].length; j++) {
            OPTNums[0][j] = (arr[0]==j);
        }
        for (int j = 1; j < OPTNums.length; j++) {
            for (int k = 1; k < OPTNums[0].length; k++) {
                if(arr[j]>k)
                    OPTNums[j][k] = OPTNums[i-1][k];
                else{
                    boolean A = OPTNums[j-1][k-arr[j]];
                    boolean B = OPTNums[j-1][k];
                    OPTNums[j][k] = A||B;
                }
            }
        }
        return OPTNums[OPTNums.length-1][OPTNums[0].length-1];
    }
}
