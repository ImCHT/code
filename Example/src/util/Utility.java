package util;

public class Utility {
    /**
     *  �����ַ�����λ��index1��λ��index2���ַ�
     * @param stringBuilder
     * @param index1
     * @param index2
     * @return
     */
    public static StringBuilder swapChar(StringBuilder stringBuilder,int index1,int index2){
        char temp = stringBuilder.charAt(index1);
        stringBuilder.setCharAt(index1,stringBuilder.charAt(index2));
        stringBuilder.setCharAt(index2,temp);
        return stringBuilder;
    }

    /**
     * �ж��ַ���a���Ƿ�����ַ���b
     * @param a
     * @param b
     * @return
     */
    public static  boolean isContained(String a,String b){
        //����ַ���A�ĳ���С���ַ���B�ĳ��ȣ�����false
        if(b.length()>a.length()){
            return false;
        }
        if(a.length()==b.length()){
            return a.equals(b);
        }
        int index1 = 0;
        int index2 = 0;
        while (index1<a.length() && index2<b.length()){
            if(a.charAt(index1)==b.charAt(index2)){
                index2++;
            }
            index1++;
        }
        return index2==b.length();
    }

    /**
     * ������������������λ��
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums,int i,int j){
        if (i==j){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * �ж�һ�������ǲ�����ȫƽ����
     * @param num
     * @return
     */
    public static boolean isCompleteSquares(int num){
        //�ж���������֮���ǲ�������
        double sqrtNum = Math.sqrt(num);
        return (int)sqrtNum+0.0==sqrtNum;
    }

    /**
     * �ж�double���ǲ���ֻ����������
     * @param num
     * @return
     */
    public static boolean doubleIsInteger(double num){
        return (long)num+0.0==num;
    }

    /**
     * ͳ���ַ���a�а������ַ���b�Ĵ���
     * @param a
     * @param b
     * @return
     */
    public static int aContaninsBNum(String a,String b){
        //�������
        if (a==null || b==null){
            return 0;
        }
        int num = 0;
        int index = 0;
        while (index < a.length()){
            if (a.indexOf(b,index)!=-1){
                num++;
                index = a.indexOf(b,index)+1;
            }else {
                break;
            }
        }
        return num;
    }

    /**
     * ͳ�Ʊ�ʾnum�Ķ���������1������
     * @param num
     * @return
     */
    public static int numOfBinary1(int num){
        int result=0;
        while (num!=0){
            num = (num-1)&num;
            result++;
        }
        return result;
    }
}
