package util;

public class Utility {
    /**
     *  交换字符串中位置index1和位置index2的字符
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
     * 判断字符串a中是否包含字符串b
     * @param a
     * @param b
     * @return
     */
    public static  boolean isContained(String a,String b){
        //如果字符串A的长度小于字符串B的长度，返回false
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
     * 交换数组中两个数的位置
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
     * 判断一个整数是不是完全平方数
     * @param num
     * @return
     */
    public static boolean isCompleteSquares(int num){
        //判断它开根号之后是不是整数
        double sqrtNum = Math.sqrt(num);
        return (int)sqrtNum+0.0==sqrtNum;
    }

    /**
     * 判断double数是不是只是整数部分
     * @param num
     * @return
     */
    public static boolean doubleIsInteger(double num){
        return (long)num+0.0==num;
    }

    /**
     * 统计字符串a中包含子字符串b的次数
     * @param a
     * @param b
     * @return
     */
    public static int aContaninsBNum(String a,String b){
        //特殊情况
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
     * 统计表示num的二进制数中1个数量
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
