package exam;

import java.util.*;

import bean.Person;

public class UtilPackage {
    public static void main(String[] args){
    }
}
/*      TreeSet���������԰���С˳���ȡֵ
        TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int num = o1.age-o2.age;
                return num!=0?num:o1.name.compareTo(o2.name);
            }
        });
        treeSet.add(new Person("һ",1));
        treeSet.add(new Person("��",2));
        treeSet.add(new Person("��",3));
        treeSet.pollLast();
        System.out.println(treeSet);
*/
/*      ArrayDeque������˫�����
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(1);arrayDeque.addFirst(2);arrayDeque.addLast(3);arrayDeque.addLast(4);
        //��ǿforѭ��������Ҳ�Ǵ�ͷ����ʼ����
        for (Integer i:arrayDeque) {
            System.out.println(i);
        }
        System.out.println(arrayDeque.removeFirst());System.out.println(arrayDeque.removeLast());
        Iterator<Integer> iterator = arrayDeque.iterator();
        //��������ͷ����ʼ����
        while(iterator.hasNext()){
            Integer num = iterator.next();
            System.out.println(num);
        }
 */

/*      HashMapʵ�����������ǿ��ת��ΪList
//        HashMap<Integer,Person> hashMap = new HashMap<>();
//        hashMap.put(1,new Person("һ",1));hashMap.put(2,new Person("��",2));hashMap.put(3,new Person("��",3));
//        //ǿ��ת��ΪListʵ������
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
//        //����
////        Set<Map.Entry<Integer,Person>> entrySet = hashMap.entrySet();
////        for (Map.Entry<Integer,Person> entry:entrySet) {
////            System.out.println(entry.getKey().toString()+entry.getValue());
////        }
 */

/*
    //��ȡ��������ֵ
    Arrays.stream(array).max().getAsInt();
 */

/*
    ��ʽ��С�����
    System.out.println(String.format("%.2f", result));
 */

/*
    BigInteger��add������compareTo������divide������pow����
 */