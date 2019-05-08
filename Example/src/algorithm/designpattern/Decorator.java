package algorithm.designpattern;

import java.io.*;
/*
    װ����ģʽ�����+װ����=װ����ģʽ
    �����̬�ؽ����θ��ӵ������ϣ���Ҫ���Ź��ܣ�װ�����ṩ�б��ڻ�������һ��ѡ��
          װ���߳����������һ��װ���ߵ����ã�������һ��װ���߻�������ķ����󣬼����µĴ���
          ����ԭ�з������ڻ��������ӹ��ܣ�ֱ���ṩ�µķ�����
          �����ڲ����޸ĵײ���������£���̬��Ϊ��������µķ�����
    ԭ�������װ���߹�ͬ��һ���������������ࡣ��˿��Ե�����һ��Ĺ��ܹ�ͬ�����󣬼����µĴ���
    Ӧ�ó�����java.io,���������InputStream�����������FileInputStream��
              װ���߸�����FilterInputStream�����������BufferedInputStream,Ϊ������������֧�ֻ������Ĺ��ܡ�
 */
public class Decorator {
    //�����Զ����װ����ģʽ����
    public static void main(String[] args){
        Sandwich sandwich = new SandwichWithVegetable(new SandwichWithEgg(new ChineseSandwich()));
        System.out.println(sandwich.getName());
        System.out.println(sandwich.getCost());
    }
    //����java.io�Զ����װ����
//    public static void main(String[] args){
//        int c;
//        try {
//            InputStream inputStream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
//            while ((c=inputStream.read())>=0){
//                System.out.print((char)c);
//            }
//            inputStream.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
//���������װ�εĶ���
abstract class Sandwich{
    String name = "������";
    double cost;

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}

//����װ����
abstract class SandwichDecorate extends Sandwich{
    Sandwich sandwich;  //��Ҫ��װ�ζ��������
}

//�������
class ChineseSandwich extends Sandwich{
    public ChineseSandwich(){
        name = "�й�������";
        cost = 10;
    }
}

//����װ����
class SandwichWithEgg extends SandwichDecorate{
    double cost = 5;
    SandwichWithEgg(Sandwich concreteSandwich){
        this.sandwich = concreteSandwich;
    }

    @Override
    public String getName() {
        return sandwich.getName()+"������";
    }

    @Override
    public double getCost() {
        return sandwich.getCost()+this.cost;
    }
}
//����װ����
class SandwichWithVegetable extends SandwichDecorate{
    double cost = 2;
    SandwichWithVegetable(Sandwich concreteSandwich){
        this.sandwich = concreteSandwich;
    }

    @Override
    public String getName() {
        return sandwich.getName()+"���߲�";
    }

    @Override
    public double getCost() {
        return sandwich.getCost()+this.cost;
    }
}

//java.io���Զ���װ����
class LowerCaseInputStream extends FilterInputStream{
    public LowerCaseInputStream(InputStream in){
        super(in);
    }
    public int read() throws IOException {
        int c = super.read();
        return (c==-1?c:Character.toLowerCase((char)c));
    }
    public int read(byte[] b,int offset,int len) throws IOException{
        int result = super.read(b,offset,len);
        for (int i = offset; i < offset+result; i++) {
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}