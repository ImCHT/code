package basic.test;

/**
 * try���������catch����finally
 * try����return֮��finallyҲ��ִ�У���������ı�return��ֵ�������γ���һ���µ�return·��
 */
public class TryReturn {
    public static void main(String[] args){
        System.out.println(testReturn());
    }
    static int testReturn(){
        int a = 1;
        try {
            a = 2;
            return a;
        }finally {
            a = 3;
        }
    }
}
