package exam.pdd;

/*
    ��Ŀ������
    ��������0-9����֪0-9ÿ������Ŀ��ô�����������������A��B��A��B����Щ������ɣ�������֪A��B���Ե�λ����������������һ�������ȵ�0����A��B�˻�����Сֵ
 */
//��С�˻�65%
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[10];
        int aLength = 0;
        int bLength = 0;
        int numberA = 0;
        int numberB = 0;
        int numsSum = 0;//����λ������
        int result1 = 0;
        for (int i = 0; i < 10; i++) {
            nums[i] = scanner.nextInt();
        }
        aLength = scanner.nextInt();
        bLength = scanner.nextInt();
        //A��Сλ��
        if(aLength>bLength){
            int temp = aLength;
            aLength = bLength;
            bLength = temp;
        }

        //�������������λ������
        for (int i = 0; i < 10; i++) {
            numsSum+=nums[i];
        }
        if(numsSum<aLength+bLength){
            System.out.println(0);
            return;
        }
        //�������0�Ŀ��ô������ڵ�������һ����
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
        //�Ӹ���С�Ŀ�ʼ�Ӹ�λ����λ������
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
        //�Ӹ�����Ŀ�ʼ�Ӹ�λ����λ������
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

