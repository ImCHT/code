package exam.xiecheng;

import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strings = new String[num];
        for (int i = 0; i < num; i++) {
            strings[i] = scanner.next();
        }
        //把路径最后的/给去了
        for (int i = 0; i < num; i++) {
            if (strings[i].charAt(strings[i].length()-1)=='/'){
                strings[i] = strings[i].substring(0,strings[i].length()-1);
            }
        }
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < num; i++) {
            if (hashMap.get(strings[i])==null){
                hashMap.put(strings[i],1);
                printNum(getLength(strings[i]),1);
            }else {
                hashMap.put(strings[i],hashMap.get(strings[i])+1);
                printNum(getLength(strings[i]),hashMap.get(strings[i]));
            }
        }
    }
    //输出数字
    public static void printNum(int length,int num){
        if (length==1){
            System.out.print("1");
        }else if (length==2){
            System.out.print("11");
        }else {
            System.out.print("1");
            for (int i = 1; i < length-1; i++) {
                System.out.print(num);
            }
            System.out.print("1");
        }
        System.out.print(" ");
    }
    //得到路径的长度
    public static int getLength(String string){
        int length = 0;
        for (int i = 0; i < string.length()-1; i++) {
            if (string.charAt(i)=='/'){
                length++;
            }
        }
        return length;
    }
}
