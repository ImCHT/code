package interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * 数学表达式求值
 * 思路：
 * 先用栈转换成后缀表达式，然后用栈对后缀表达式求值
 * @Author CHT
 */
public class HuaWei0429 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String expression = null;
        while (true){
            expression = scanner.next();
            System.out.println(String.format("%.2f",new HuaWei0429().resultOfMathematicalExpression(expression)));
        }
    }
    /**
     * 根据后缀表达式计算结果
     * @param mathematicalExpression
     * @return
     */
    private double resultOfMathematicalExpression(String mathematicalExpression){
        String postExpression = postMathematicalExpression(mathematicalExpression);
        String[] strings = postExpression.split("#");
        Stack<Double> operandStack = new Stack<>();
        double operandLeft = 0,operandRight = 0;
        for (String string:strings) {
            switch (string){
                case "+":{
                    operandRight = operandStack.pop();
                    operandLeft = operandStack.pop();
                    operandStack.push(operandLeft+operandRight);
                    break;
                }
                case "-":{
                    operandRight = operandStack.pop();
                    operandLeft = operandStack.pop();
                    operandStack.push(operandLeft-operandRight);
                    break;
                }
                case "*":{
                    operandRight = operandStack.pop();
                    operandLeft = operandStack.pop();
                    operandStack.push(operandLeft*operandRight);
                    break;
                }
                case "/":{
                    operandRight = operandStack.pop();
                    operandLeft = operandStack.pop();
                    operandStack.push(operandLeft/operandRight);
                    break;
                }
                default:
                    operandStack.push(Double.parseDouble(string));
            }
        }
        return operandStack.pop();
    }

    /**
     * 将中缀表达式转换成后缀表达式。用'#'分隔
     * @param mathematicalExpression
     * @return
     */
    private String postMathematicalExpression(String mathematicalExpression){
        //后缀表达式
        StringBuilder postExpression = new StringBuilder();
        //操作符栈
        Stack<Character> operatorStack = new Stack<>();
        //数字直接添加到后缀表达式，运算符按照优先级从高到低排序
        for (int i = 0; i < mathematicalExpression.length(); i++) {
            //0~9直接添加到后缀表达式
            if (mathematicalExpression.charAt(i)>='0' && mathematicalExpression.charAt(i)<='9'){
                postExpression.append(mathematicalExpression.charAt(i));

            }//'+' '-' 运算符的优先级只比 '(' 高
            else if (mathematicalExpression.charAt(i)=='+' || mathematicalExpression.charAt(i)=='-'){
                postExpression.append('#');
                if (operatorStack.empty() || operatorStack.peek()=='('){
                    operatorStack.push(mathematicalExpression.charAt(i));
                }else {
                    while (!operatorStack.empty() && operatorStack.peek()!='('){
                        postExpression.append(operatorStack.pop()).append('#');
                    }
                    operatorStack.push(mathematicalExpression.charAt(i));
                }
            }//'*' '/'的优先级比 '+' '-' '('高
            else if (mathematicalExpression.charAt(i)=='*' || mathematicalExpression.charAt(i)=='/'){
                postExpression.append('#');
                if (operatorStack.empty() || operatorStack.peek()=='(' || operatorStack.peek()=='+' || operatorStack.peek()=='-'){
                    operatorStack.push(mathematicalExpression.charAt(i));
                }else {
                    while (!operatorStack.empty() && operatorStack.peek()!='(' && operatorStack.peek()!='+' && operatorStack.peek()!='-'){
                        postExpression.append(operatorStack.pop()).append('#');
                    }
                    operatorStack.push(mathematicalExpression.charAt(i));
                }
            }// '('的优先级比前面的运算符都高，比后面的运算符优先级低
            else if (mathematicalExpression.charAt(i)=='('){
                operatorStack.push(mathematicalExpression.charAt(i));
            }// 碰到')'，将'('之前的运算符弹出，最后将'('弹出
            else if (mathematicalExpression.charAt(i)==')'){
                postExpression.append('#');
                while (operatorStack.peek()!='('){
                    postExpression.append(operatorStack.pop()).append('#');
                }
                postExpression.deleteCharAt(postExpression.length()-1);
                operatorStack.pop();
            }
        }
        while (!operatorStack.empty()){
            postExpression.append("#").append(operatorStack.pop());
        }
        return postExpression.toString();
    }
}
