package exam.jd;

/*
    ��Ŀ������
    ������ͻȻ�Ż��ˣ��ֳ���Ҫ������ɢ�����ǹ��������̫խ�ˣ�ͬʱֻ������һ����ͨ��������֪������������������λ�ֲ���
    ��λ�ֲ�ͼ��һ��������֪ÿ����λ�϶�����һ���ˣ���ȫ���������ĸ�����Ҳ����1�Ž���λ���ϡ������ڵ��ϵ���ÿ�붼��
    ��������ǰ��һ����㣬���ǳ��˰�ȫ�������⣬û���κ�һ��������ͬʱ�������������ϵ��ˣ������Ҫһ�ֲ��ԣ���ʹ��
    ��Ⱥ������ɢ�����ڲ�ȡ���Ų��Ե�����£��������������ڶ೤ʱ������ɢ��ɡ�
    ���룺
    ��һ�а���һ��������n�������Ľ��������1<=n<=100000����
    ��������n-1�У�ÿ��������������x��y����ʾ��x��y���֮�����һ���ߡ�(1<=x<=y<=n)
    �����
    ���������һ������������ʾ����Ҫ�����ʱ��
    ��������
    6
    2 1
    3 2
    4 3
    5 2
    6 1
    �������
    4
 */
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StringBuilder> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n-1; i++) {
            String j = scanner.next();  //���
            String k = scanner.next();  //С��
            //�����µ�����
            if (k.equals("1")){
                StringBuilder stringBuilder = new StringBuilder(j);
                list.add(stringBuilder);
            }else { //������֮ǰ������
                for (StringBuilder str:list) {
                    if (str.indexOf(k)!=-1){
                        str.append(j);
                        break;
                    }
                }
            }
        }
        int result = 0;
        for (StringBuilder str:list) {
            if (str.length()>result){
                result = str.length();
            }
        }
        System.out.println(result);
    }
}
