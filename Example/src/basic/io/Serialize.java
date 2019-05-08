package basic.io;

import java.io.*;

public class Serialize {
    public static void main(String[] args){
        Person person = new Person("1");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("序列化"));
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("序列化"));
            Person person1 = (Person) objectInputStream.readObject();
            System.out.println(person.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class Person implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    Person(String name){
        this.name = name;
    }
}