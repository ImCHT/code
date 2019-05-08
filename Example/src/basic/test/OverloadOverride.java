package basic.test;

import java.util.*;

/**
 * ����(overload)����д(override)����
 */
public class OverloadOverride extends Parent{
    public static void main(String[] args){
        new OverloadOverride().overload(1,"2");
        new OverloadOverride().overload("2",1);
    }
    /**
     * �������أ��������������� or ���� or ˳���в�һ�����������
     * @param a
     * @param b
     */
    void overload(int a,String b){
        System.out.println("override"+a+b);
    }
    void overload(String b,int a){
        System.out.println("override"+a+b);
    }

    /**
     * �����з��������ֲ����븸��һ��������ֵ���׳��쳣��������Ҫ
     * @return
     */
    @Override
    protected ArrayList<Integer> overload(){
        super.overload();
        System.out.println("child overload");
        return new ArrayList<>();
    }
}

class Parent{
    protected List<Integer> overload() throws RuntimeException{
        System.out.println("Parent override");
        return new ArrayList<>();
    }
}
