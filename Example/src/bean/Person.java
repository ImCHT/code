package bean;

//implements Comparable<Person>
public class Person {
    private  int privateValue = 1;
    public String name;
    public int age;
    public static int i = 1;
    private void privateMethod(){
        System.out.println("privateMethod");
    }
    public static void staticMethod(){
        System.out.println("staticMethod");
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Person(){};
    @Override
    public String toString(){
        return name+"£º"+age;
    }

//    @Override
//    public int compareTo(Person o) {
//        int num = this.age-o.age;
//        return num==0?this.name.compareTo(o.name):num;
//    }
}
