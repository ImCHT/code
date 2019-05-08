package basic.test;

/**
 * try语句块后必须跟catch或者finally
 * try语句块return之后，finally也会执行，不过不会改变return的值，除非形成了一条新的return路径
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
