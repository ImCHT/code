package interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * ��ѧ���ʽ��ֵ
 * ˼·��
 * ����ջת���ɺ�׺���ʽ��Ȼ����ջ�Ժ�׺���ʽ��ֵ
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
     * ���ݺ�׺���ʽ������
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
     * ����׺���ʽת���ɺ�׺���ʽ����'#'�ָ�
     * @param mathematicalExpression
     * @return
     */
    private String postMathematicalExpression(String mathematicalExpression){
        //��׺���ʽ
        StringBuilder postExpression = new StringBuilder();
        //������ջ
        Stack<Character> operatorStack = new Stack<>();
        //����ֱ����ӵ���׺���ʽ��������������ȼ��Ӹߵ�������
        for (int i = 0; i < mathematicalExpression.length(); i++) {
            //0~9ֱ����ӵ���׺���ʽ
            if (mathematicalExpression.charAt(i)>='0' && mathematicalExpression.charAt(i)<='9'){
                postExpression.append(mathematicalExpression.charAt(i));

            }//'+' '-' ����������ȼ�ֻ�� '(' ��
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
            }//'*' '/'�����ȼ��� '+' '-' '('��
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
            }// '('�����ȼ���ǰ�����������ߣ��Ⱥ������������ȼ���
            else if (mathematicalExpression.charAt(i)=='('){
                operatorStack.push(mathematicalExpression.charAt(i));
            }// ����')'����'('֮ǰ����������������'('����
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
