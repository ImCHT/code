package basic.reject;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RejectTest {
    public static  void main(String[] args){
        try {
            //ͨ�����䴴��ʵ������
            Class personClass = Class.forName("bean.Person");
            Constructor constructor = personClass.getConstructor(String.class,int.class);
            Person personInstance = (Person)constructor.newInstance("CHT",23);
            System.out.println(personInstance.toString());
            //ͨ�������ȡʵ������
            Field nameField = personClass.getField("name");
            Object property = nameField.get(personInstance);
            System.out.println(property);
            //ͨ�������ȡ��̬����
            nameField = personClass.getField("i");
            property = nameField.get(personClass);
            System.out.println(property);
            //ͨ������ʹ��ʵ������
            Method method = personClass.getMethod("toString");
            System.out.println(method.invoke(personInstance));
            //ͨ������ʹ�þ�̬����
            method = personClass.getMethod("staticMethod");
            method.invoke(null);
            //�������˽�б���
            nameField = personClass.getDeclaredField("privateValue");
            nameField.setAccessible(true);
            property = nameField.getInt(personInstance);
            System.out.println(property);
            //�������˽�з���
            method = personClass.getDeclaredMethod("privateMethod");
            method.setAccessible(true);
            method.invoke(personInstance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
