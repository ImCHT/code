package exam.pdd;

/*
    题目描述：
    现有数组0-9，已知0-9每个数组的可用次数，另有两个整数A和B，A和B由这些数字组成，并且已知A和B各自的位数，两个数可以有一个或多个先导0，求A与B乘积的最小值
 */
//最小乘积65%
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[10];
        int aLength = 0;
        int bLength = 0;
        int numberA = 0;
        int numberB = 0;
        int numsSum = 0;//可用位数总数
        int result1 = 0;
        for (int i = 0; i < 10; i++) {
            nums[i] = scanner.nextInt();
        }
        aLength = scanner.nextInt();
        bLength = scanner.nextInt();
        //A较小位数
        if(aLength>bLength){
            int temp = aLength;
            aLength = bLength;
            bLength = temp;
        }

        //特殊情况：可用位数不够
        for (int i = 0; i < 10; i++) {
            numsSum+=nums[i];
        }
        if(numsSum<aLength+bLength){
            System.out.println(0);
            return;
        }
        //特殊情况0的可用次数大于等于其中一个数
        if(nums[0]>=aLength || nums[0]>=bLength){
            System.out.println(0);
            return;
        }
        int zuixiaokeyong = 0;

        int[] nums1 = Arrays.copyOf(nums,10);
        int aLength1 = aLength;
        int bLength1 = bLength;
        int numberA1 = 0;
        int numberB1 = 0;
        int result2 = 0;
        //从个数小的开始从高位到低位填数字
        while (aLength!=0){
            if(nums[zuixiaokeyong]!=0){
                numberA += zuixiaokeyong*Math.pow(10,aLength-1);
                nums[zuixiaokeyong]--;
                aLength--;
            }else{
                zuixiaokeyong++;
            }
        }
//        zuixiaokeyong = 0;
        while (bLength!=0){
            if(nums[zuixiaokeyong]!=0){
                numberB += zuixiaokeyong*Math.pow(10,bLength-1);
                nums[zuixiaokeyong]--;
                bLength--;
            }else{
                zuixiaokeyong++;
            }
        }
        result1 = numberA*numberB;

        zuixiaokeyong = 0;
        //从个数大的开始从高位到低位填数字
        while (bLength1!=0){
            if(nums1[zuixiaokeyong]!=0){
                numberB1 += zuixiaokeyong*Math.pow(10,bLength1-1);
                nums1[zuixiaokeyong]--;
                bLength1--;
            }else{
                zuixiaokeyong++;
            }
        }
        while (aLength1!=0){
            if(nums1[zuixiaokeyong]!=0){
                numberA1 += zuixiaokeyong*Math.pow(10,aLength1-1);
                nums1[zuixiaokeyong]--;
                aLength1--;
            }else{
                zuixiaokeyong++;
            }
        }
//        zuixiaokeyong = 0;

        result2 = numberA1*numberB1;
        if (result2>result1){
            System.out.println(result1);
        }else {
            System.out.println(result2);
        }

    }
}

