package exam.xiecheng;

import java.util.*;
//����ת
//���룺[1,2,3,4,5] 3
//�����[3,2,1,4,5]
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = scanner.nextInt();
        //ȥ��ǰ���������
        str = str.substring(1, str.length() - 1);
        String[] strArray = str.split(",");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        //���з�ת
        int[] tempArray = new int[length];
        int index = 0;

    }
}

/*
//�����ռ䲻����
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = scanner.nextInt();
        //ȥ��ǰ���������
        str = str.substring(1,str.length()-1);
        String[] strArray = str.split(",");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        //���з�ת
        int[] tempArray = new int[length];
        int index = 0;
        while (index+length<=array.length){
            //���з�ת
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
