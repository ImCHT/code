package exam.tengxun;

//100%
/**
    ��Ŀ������
    ����һ������0��1���ַ�������1��0���ھͿ���ɾ���������ַ���
    ����ַ����������������ʣ�ַ����ĳ���
    ˼·��
    �������õ��ַ�0��1�������������ľ���ֵ
 */
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String str = scanner.next();
        int numOfZero = 0;
        int numOfOne = 0;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i)=='0'){
                numOfZero++;
            }else {
                numOfOne++;
            }
        }
        System.out.println(Math.abs(numOfOne-numOfZero));
    }

}
