package basic.test;

import java.util.*;

/**
 * 重载(overload)和重写(override)测试
 */
public class OverloadOverride extends Parent{
    public static void main(String[] args){
        new OverloadOverride().overload(1,"2");
        new OverloadOverride().overload("2",1);
    }
    /**
     * 方法重载：方法参数的数量 or 类型 or 顺序有不一样的造成重载
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
     * 子类中方法的名字参数与父类一样，返回值和抛出异常的类型需要
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
