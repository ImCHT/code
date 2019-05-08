package exam;

import java.util.*;
import bean.Person;
public class Common {
    public static void main(String[] args){
        //循环输入
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
        //多行输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
        //排序数组
        int[] array = {3,2,1,4};
        Arrays.sort(array);
        for (int i:array) {
            System.out.print(i);
        }
        //排序集合
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);arrayList.add(2);arrayList.add(1);
        Collections.sort(arrayList);
        System.out.println(arrayList);
        //自定义排序规则，Comparator接口
        ArrayList<Person> arrayList1 = new ArrayList<>();
        arrayList1.add(new Person("a",3));arrayList1.add(new Person("a",1));arrayList1.add(new Person("a",2));
        Collections.sort(arrayList1, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age<o2.age)
                    return -1;
                else if(o1.age>o2.age)
                    return 1;
                return 0;
            }
        });
        System.out.println(arrayList1);
        //String转化为int
        String str = "123";
        int i = Integer.valueOf(str);
    }
}
//next(),nextLine(),nextInt()
//集合排序 public static <T extends Comparable<? super T>> void algorithm.sort(List<T> list)
//自定义排序接口 public static <T> void algorithm.sort(List<T> list,Comparator<? super T> c)。Collections.algorithm.sort(集合)
//数组排序 static void algorithm.sort(Object[] a) 。Arrays.algorithm.sort(数组)
//笔试多实例输入：while(sc.hasNext())
