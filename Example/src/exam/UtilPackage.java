package exam;

import java.util.*;

import bean.Person;

public class UtilPackage {
    public static void main(String[] args){
    }
}
/*      TreeSet范例。可以按大小顺序获取值
        TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int num = o1.age-o2.age;
                return num!=0?num:o1.name.compareTo(o2.name);
            }
        });
        treeSet.add(new Person("一",1));
        treeSet.add(new Person("二",2));
        treeSet.add(new Person("三",3));
        treeSet.pollLast();
        System.out.println(treeSet);
*/
/*      ArrayDeque范例，双向队列
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(1);arrayDeque.addFirst(2);arrayDeque.addLast(3);arrayDeque.addLast(4);
        //增强for循环遍历，也是从头部开始返回
        for (Integer i:arrayDeque) {
            System.out.println(i);
        }
        System.out.println(arrayDeque.removeFirst());System.out.println(arrayDeque.removeLast());
        Iterator<Integer> iterator = arrayDeque.iterator();
        //迭代器从头部开始返回
        while(iterator.hasNext()){
            Integer num = iterator.next();
            System.out.println(num);
        }
 */

/*      HashMap实现有序遍历，强制转化为List
//        HashMap<Integer,Person> hashMap = new HashMap<>();
//        hashMap.put(1,new Person("一",1));hashMap.put(2,new Person("二",2));hashMap.put(3,new Person("三",3));
//        //强制转化为List实现有序
//        List<Map.Entry<Integer,Person>> entryList = new ArrayList<Map.Entry<Integer, Person>>(hashMap.entrySet());
//        Collections.algorithm.sort(entryList, new Comparator<Map.Entry<Integer, Person>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Person> o1, Map.Entry<Integer, Person> o2) {
//                return o1.getKey()-o2.getKey();
//            }
//        });
//        for (Map.Entry<Integer,Person> entry:entryList) {
//            System.out.println(entry.getKey().toString()+entry.getValue());
//        }
//        //无序
////        Set<Map.Entry<Integer,Person>> entrySet = hashMap.entrySet();
////        for (Map.Entry<Integer,Person> entry:entrySet) {
////            System.out.println(entry.getKey().toString()+entry.getValue());
////        }
 */

/*
    //获取数组的最大值
    Arrays.stream(array).max().getAsInt();
 */

/*
    格式化小数输出
    System.out.println(String.format("%.2f", result));
 */

/*
    BigInteger：add方法，compareTo方法，divide方法，pow方法
 */