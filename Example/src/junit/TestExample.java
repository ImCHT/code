package junit;

import util.Utility;

/**
    ��Ŀ������
    ˼·��
    @Author CHT
 */
public class TestExample{
    public static void main(String[] args){
        System.out.println(String.format("$%.2f", 2.13312));
    }
    public void  test(){
        throw new IllegalArgumentException("amount must be greater than zero");
    }
}