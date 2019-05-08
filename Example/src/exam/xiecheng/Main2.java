package exam.xiecheng;

import java.util.*;
//链表反转
//输入：[1,2,3,4,5] 3
//输出：[3,2,1,4,5]
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = scanner.nextInt();
        //去掉前后的中括号
        str = str.substring(1, str.length() - 1);
        String[] strArray = str.split(",");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        //进行翻转
        int[] tempArray = new int[length];
        int index = 0;

    }
}

/*
//常量空间不满足
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = scanner.nextInt();
        //去掉前后的中括号
        str = str.substring(1,str.length()-1);
        String[] strArray = str.split(",");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        //进行翻转
        int[] tempArray = new int[length];
        int index = 0;
        while (index+length<=array.length){
            //进行翻转
            for (int i = 0; i < length; i++) {
                tempArray[i] = array[index+i];
            }
            for (int i = 0; i < length; i++) {
                array[index+i] = tempArray[length-i-1];
            }
            index+=length;
        }
        System.out.print("[");
        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i]+",");
        }
        System.out.print(array[array.length-1]+"]");
    }
}
 */
