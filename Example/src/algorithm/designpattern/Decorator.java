package algorithm.designpattern;

import java.io.*;
/*
    装饰者模式：组件+装饰器=装饰者模式
    概念：动态地将责任附加到对象上，想要扩张功能，装饰者提供有别于基础的另一种选择。
          装饰者持有组件或上一层装饰者的引用，调用上一层装饰者或者组件的方法后，加入新的处理。
          覆盖原有方法，在基础上增加功能；直接提供新的方法。
          可以在不用修改底层代码的情况下，动态地为组件增加新的方法。
    原理：组件和装饰者共同是一个抽象组件类的子类。因此可以调用上一层的功能共同方法后，加入新的处理。
    应用场景：java.io,抽象组件是InputStream，具体组件是FileInputStream。
              装饰者父类是FilterInputStream，具体组件是BufferedInputStream,为输入流加入了支持缓冲区的功能。
 */
public class Decorator {
    //测试自定义的装饰者模式代码
    public static void main(String[] args){
        Sandwich sandwich = new SandwichWithVegetable(new SandwichWithEgg(new ChineseSandwich()));
        System.out.println(sandwich.getName());
        System.out.println(sandwich.getCost());
    }
    //测试java.io自定义的装饰类
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
//抽象组件，装饰的对象
abstract class Sandwich{
    String name = "三明治";
    double cost;

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}

//抽象装饰类
abstract class SandwichDecorate extends Sandwich{
    Sandwich sandwich;  //需要有装饰对象的引用
}

//具体组件
class ChineseSandwich extends Sandwich{
    public ChineseSandwich(){
        name = "中国三明治";
        cost = 10;
    }
}

//具体装饰类
class SandwichWithEgg extends SandwichDecorate{
    double cost = 5;
    SandwichWithEgg(Sandwich concreteSandwich){
        this.sandwich = concreteSandwich;
    }

    @Override
    public String getName() {
        return sandwich.getName()+"，鸡蛋";
    }

    @Override
    public double getCost() {
        return sandwich.getCost()+this.cost;
    }
}
//具体装饰类
class SandwichWithVegetable extends SandwichDecorate{
    double cost = 2;
    SandwichWithVegetable(Sandwich concreteSandwich){
        this.sandwich = concreteSandwich;
    }

    @Override
    public String getName() {
        return sandwich.getName()+"，蔬菜";
    }

    @Override
    public double getCost() {
        return sandwich.getCost()+this.cost;
    }
}

//java.io的自定义装饰类
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